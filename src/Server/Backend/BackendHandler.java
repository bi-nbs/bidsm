package Server.Backend;

import Server.Host.Host;
import Server.Host.LinuxHost;
import Server.ServerProperties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.Inet4Address;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * A backend handler is used to handle a single database based on the configuration files.
 */
public class BackendHandler implements Backend{

    private static Logger logger = LogManager.getLogger();

    private final Database database;

    /**
     * The constructor doesn't take any arguments. This is due to the fact that it will load properties from
     * the configuration files. A database will be constructed based on the configuration.
     * So far the backend handler only has backends of the sql type.
     */
    public BackendHandler() {

        String databaseName = ServerProperties.getProperty("databaseName");
        String databaseUsername = ServerProperties.getProperty("databaseUsername");
        String databasePassword = ServerProperties.getProperty("databasePassword");
        String databaseIpaddress = ServerProperties.getProperty("databaseIpaddress");
        String databaseType = ServerProperties.getProperty("databaseType");

        switch (databaseType){
            case "mysql":
                this.database = new MySQLDatabase(databaseName, databaseUsername, databasePassword, databaseIpaddress);
                break;
            default:
                this.database = null;
                break;
        }

        if (this.database != null){
            this.database.openConnection();
        }
    }

    public void stop(){
        this.database.closeConnection();
    }

    @Override
    public List<Host> getAllHosts() {
        return this.database.getAllHosts();
    }

    @Override
    public void updateHost(Host host) {
        this.database.updateHost(host);
    }
}
