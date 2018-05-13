package Server.Database;

import com.mysql.cj.log.Log;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

public abstract class Database {
    private final String name;
    private final String username;
    private final String password;
    private InetAddress ip;
    private boolean connectionOpen = false;

    private static Logger logger = LogManager.getLogger();

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

    public boolean isConnectionOpen() {
        return connectionOpen;
    }

    void setConnectionOpen(boolean connectionOpen) {
        this.connectionOpen = connectionOpen;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public InetAddress getIp() {
        return ip;
    }

    public String getName() {
        return name;
    }
}
