package Server.Backend;

import Server.Host.Host;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testBackendHandler {

    private static Logger logger = LogManager.getLogger();

    private BackendHandler backendHandler = null;

    @BeforeEach
    public void testBeforeEach(){
        this.backendHandler = new BackendHandler();
    }

    @Test
    public void testGetAllHosts01(){
        List<Host> hosts = backendHandler.getAllHosts();
        hosts.forEach(host -> logger.info(host.toString()));
    }

    @Test
    public void testUpdateHost(){
        List<Host> hosts = backendHandler.getAllHosts();

        hosts.get(0).setName("Host2Altered");
        this.backendHandler.updateHost(hosts.get(0));
    }

}
