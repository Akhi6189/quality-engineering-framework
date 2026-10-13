package config;

import Exceptions.ConfigurationException;
import constants.FrameworkConstants;

import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.Properties;

public class ConfigReader {
    private static final Properties prop = new Properties();

    static {
        String env = System.getProperty(FrameworkConstants.ENV_PROPERTY, FrameworkConstants.DEFAULT_ENV).toLowerCase(Locale.ROOT);
        String fileName = env + ".properties";
        try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream(fileName)) {
            if (input == null) {
                throw new ConfigurationException("Configuration file '" + fileName + "' not found in the classpath!");
            }
            prop.load(input);
        } catch (IOException e) {
            throw new ConfigurationException("Failed to load configuration file: " + fileName, e);
        }
    }

    public static String getProperty(String key) {
        String value = System.getProperty(key);
        if (value == null) {
            value = prop.getProperty(key);
        }
        if (value == null) {
            throw new ConfigurationException("Property key '" + key + "' not found in the active properties file.");
        }
        return value.trim();
    }

    public static int getIntProperty(String key) {
        String value = getProperty(key);
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new ConfigurationException("Configuration key '" + key + "' with value '" + value + "' cannot be converted to an Integer.", e);
        }
    }

    public static boolean getBooleanProperty(String key) {
        String value = getProperty(key);
        if (!value.equalsIgnoreCase("true") && !value.equalsIgnoreCase("false")) {
            throw new ConfigurationException("Configuration key '" + key + "' with value '" + value + "' is not a valid boolean (expected 'true' or 'false').");
        }
        return Boolean.parseBoolean(value);
    }

}