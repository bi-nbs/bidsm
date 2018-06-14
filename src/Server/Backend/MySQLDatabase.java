package Server.Backend;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLDatabase extends Database{
    private Connection SQLConnection;

    private static Logger logger = LogManager.getLogger();

    public MySQLDatabase(String name, String username, String password, String ip) {
        super(name, username, password, ip);
    }


    /**
     * Opens a connection to a MySQL database using the information that was provided through the constructor.
     *
     */
    @Override
    public void openConnection() {
        logger.info("Trying to open connection to the database");
        String connectionString = "jdbc:mysql://"+ this.getIp().getHostAddress() +"/" + this.getName() + "?" + "user=" + this.getUsername() + "&password=" + this.getPassword() + "&" + "useSSL=false";

        if (!this.isConnectionOpen()) {
            try {
                logger.debug(connectionString);
                Class.forName("com.mysql.cj.jdbc.Driver");
                this.SQLConnection = DriverManager.getConnection(connectionString);
                logger.info("Connection was opened");
                this.setConnectionOpen(true);
            } catch (SQLException | ClassNotFoundException e) {
                logger.error("Connection to database failed");
                logger.error(e.getMessage());
                this.setConnectionOpen(false);
            }
        }
        else {
            logger.info("Backend connection is already opened");
        }
    }

    @Override
    public void closeConnection() {
        logger.info("Closing database connection");
        if (this.isConnectionOpen()) {
            logger.info("Trying to close");
            try {
                this.SQLConnection.close();
                logger.info("Connection was closed successfully");
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
        }else{
            logger.info("Connection is already closed");
        }
    }

    @Override
    public boolean isConnectionOpen() {
        logger.debug("Verifying if the connection is open");

        if (this.SQLConnection != null) {
            try {
                logger.debug("SQL connection isClose: " + this.SQLConnection.isClosed());
                logger.debug("SQL connection is opened");
                return !this.SQLConnection.isClosed();
            } catch (SQLException e) {
                logger.error(e.getMessage());
                return false;
            }
        }
        else{
            logger.debug("SQL connection is closed");
            return false;
        }
    }
}
