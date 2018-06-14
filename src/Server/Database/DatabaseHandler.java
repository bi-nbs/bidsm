package Server.Database;

import Server.ServerProperties;

/**
 * A database handler is used to handle a single database based on the configuration files.
 */
public class DatabaseHandler {

    private final Database database;

    /**
     * The constructor doesn't take any arguments. This is due to the fact that it will load properties from
     * the configuration files. A database will be constructed based on the configuration.
     */
    public DatabaseHandler() {

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
            this.database.closeConnection();
        }
    }

}
