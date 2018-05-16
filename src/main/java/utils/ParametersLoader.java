package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

/**
 * Created by Dmitriy.Kruchek on 22.12.2017.
 */
public class ParametersLoader {
    private static Logger logger = LoggerFactory.getLogger(ParametersLoader.class);

    private static Properties selenideConfigProperties = new Properties();
    private static Properties inputDataProperties = new Properties();
    private static Properties webDriverPathProperties = new Properties();

    private static HashMap<String, Properties> propertiesHashMap = new HashMap<String, Properties>() {{
        put("properties/selenideConfig.properties", selenideConfigProperties);
        put("properties/inputData.properties", inputDataProperties);
        put("properties/webDriversPaths.properties", webDriverPathProperties);
    }};

    static {
        propertiesHashMap.keySet().stream().forEach(path -> {
            loadProperties(propertiesHashMap.get(path), path);
        });
    }

    public static String getSelenideProperty(Enum key) {
        return selenideConfigProperties != null && !selenideConfigProperties.isEmpty() ? selenideConfigProperties.getProperty(key.name()) : null;
    }

    public static String getInputDataProperty(Enum key) {
        return inputDataProperties != null && !inputDataProperties.isEmpty() ? inputDataProperties.getProperty(key.name()) : null;
    }

    public static String getWebDriverPathProperty(Enum key) {
        return webDriverPathProperties != null && !webDriverPathProperties.isEmpty() ? webDriverPathProperties.getProperty(key.name()) : null;
    }

    private static void loadProperties(Properties propertiesName, String resourcePath) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        try (InputStream resourceStream = loader.getResourceAsStream(resourcePath)) {
            propertiesName.load(resourceStream);
        } catch (IOException ioe) {
            logger.error(ioe.getMessage());
        }
    }
}
