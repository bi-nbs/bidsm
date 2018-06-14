package Server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class ServerProperties {
    private static Logger logger = LogManager.getLogger();

    private static final Properties properties = loadProperties();

    /**
     * Loads the default properties from the cfg folder. Also loads the properties that are set by the user
     * and overwrites the default properties accordingly. If no settings files are found new ones are created.
     * @return
     */
    public static Properties loadProperties(){

        Properties defaultProperties = new Properties();
        Properties propertiesToReturn;

        InputStream is = ClassLoader.getSystemResourceAsStream("settings");
        InputStream isDefault = ClassLoader.getSystemResourceAsStream("settings.default");

        try {
            defaultProperties.load(isDefault);
            isDefault.close();

            propertiesToReturn = new Properties(defaultProperties);
            propertiesToReturn.load(is);
            return propertiesToReturn;

        } catch (IOException e) {
            logger.debug("No configuration file found");
        }
        return defaultProperties;
    }

    private static void getDefaultProperties(){

    }

    private static void buildConfigFiles(){

    }

    /**
     * Returns the property that matches the input string
     * @param property property is the string identifier of the property.
     * @return returns the corresponding value of the property that was provided through the argument.
     */
    public static String getProperty(String property){
        return properties.getProperty(property);
    }

    /**
     * @return Returns the properties object
     */
    public static Properties getProperties() {
        return properties;
    }
}
