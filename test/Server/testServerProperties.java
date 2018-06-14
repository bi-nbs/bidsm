package Server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class testServerProperties {

    private static Logger logger = LogManager.getLogger();

    @BeforeEach
    public void testBeforeEach(){
    }

    @Test
    public void testGetProperties01(){
        logger.info("Printing all properties");
        ServerProperties.getProperties().entrySet().forEach(prop ->
                logger.debug(prop.getKey() + "=" + prop.getValue())
        );
    }

}
