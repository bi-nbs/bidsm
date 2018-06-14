package Server.Backend;

import Server.Host.Host;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testBackendHandler {

    private static Logger logger = LogManager.getLogger();

    private BackendHandler backendHandler = null;

    @BeforeEach
    public void testBeforeEach(){
        this.backendHandler = new BackendHandler();
    }

    @Test
    public void testGetHostByID01(){
        Host host = this.backendHandler.getHostByID(1);
        logger.debug("hostID: " + host.getID() +" hostName: " + host.getName() + " hostIP: " + host.getIp());
        assertEquals(host.getID(), 1);
        assertEquals(host.getName(), "Host1");
        assertEquals(host.getIp(), "192.168.127.1");
        this.backendHandler.stop();
    }
}
