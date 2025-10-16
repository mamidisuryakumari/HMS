package ui.engine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesManager {

    private static final Logger log = LoggerFactory.getLogger(PropertiesManager.class);
    public static Properties properties;

    public static Properties loadConfigProperties() {
        try (InputStream inputStream = PropertiesManager.class.getClassLoader().getResourceAsStream("config.properties")) {

            if (inputStream == null) {
                throw new FileNotFoundException("config.properties not found in classpath");
            }
            properties = new Properties();
            properties.load(inputStream);
            log.info("Config properties loaded successfully");
        } catch (Exception e) {
            log.error("Error loading congig.properties", e);
            throw new RuntimeException("Failed to load configuration", e);
        }
        return properties;
    }

    public static String getProperty(String key) {
        loadConfigProperties();
        return properties.getProperty(key);
    }


}
