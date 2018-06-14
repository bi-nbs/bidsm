package Server.Database;

import com.mysql.cj.log.Log;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Abstract database class that will be used to model a database connection.
 */
public abstract class Database {
    private final String name;
    private final String username;
    private final String password;
    private InetAddress ip;
    private boolean connectionOpen = false;

    private static Logger logger = LogManager.getLogger();

    /**
     * This is the default constructor for the database class. It requires information about the database that will be used when working with the database.
     * @param name Name of the database. This should match the actual name of the database that is going to be used.
     * @param username Username that is used to connect to the database.
     * @param password Password for the database
     * @param ip This should be the ip of the mysql server. It must have the following format xxx.xxx.xxx.xxx, example: 192.168.0.12.
     */
    public Database(String name,String username, String password, String ip) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.ip = this.buildInetAddressFromString(ip);
    }

    private InetAddress buildInetAddressFromString(String ip){
        logger.debug("Building new InetAdress object from string");
        logger.debug("The ip string is: " + ip);

        InetAddress tempInetAdress;

        try {
            tempInetAdress =  Inet4Address.getByName(ip);
        } catch (UnknownHostException e) {
            logger.error("InetAdress object could not be build");
            logger.error(e.getMessage());
            return null;
        }

        logger.debug("InetAdress was build from string");
        return tempInetAdress;
    }

    public abstract void openConnection();

    boolean isConnectionOpen() {
        return connectionOpen;
    }

    protected void setConnectionOpen(boolean connectionOpen) {
        this.connectionOpen = connectionOpen;
    }

    protected String getUsername() {
        return username;
    }

    protected String getPassword() {
        return password;
    }

    InetAddress getIp() {
        return ip;
    }

    String getName() {
        return name;
    }
}
