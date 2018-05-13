package Server;

import Server.DedicatedServer.DedicatedServer;
import Server.Host.Host;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class Server {

    private static Logger logger = LogManager.getLogger();
    private Map<DedicatedServer, Host> dedicatedServerHostMap = new HashMap<>();

    public static void main(String[] argsv){
        logger.info("Server starting!");
    }
}
