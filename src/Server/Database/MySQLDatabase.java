package Server.Database;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.InetAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLDatabase extends Database{
    Connection SQLConnection;

    private static Logger logger = LogManager.getLogger();

    public MySQLDatabase(String name, String username, String password, String ip) {
        super(name, username, password, ip);
    }


    @Override
    public void openConnection() {
        logger.info("Trying to open connection to the database");

        String connectionString = "jdbc:mysql://"+ this.getIp().getHostAddress() +"/" + this.getName() + "?" + "user=" + this.getUsername() + "&password=" + this.getPassword() + "&" + "useSSL=false";

        try{
            logger.debug(connectionString);
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.SQLConnection = DriverManager.getConnection(connectionString);
        } catch (SQLException e) {
            logger.error("Connection to database failed");
            logger.error(e.getMessage());
            this.setConnectionOpen(false);
            return;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        this.setConnectionOpen(true);
        logger.info("Connection was opened");
    }
}
