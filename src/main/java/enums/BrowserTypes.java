package enums;

import Exceptions.ConfigurationException;

public enum BrowserTypes {
    CHROME,
    FIREFOX,
    EDGE;

    public static BrowserTypes fromString(String text) {
        if (text == null || text.trim().isEmpty()) {
            throw new ConfigurationException("Browser value in properties file cannot be null or empty.");
        }
        for (BrowserTypes b : BrowserTypes.values()) {
            if (b.name().equalsIgnoreCase(text.trim())) {
                return b;
            }
        }
        throw new ConfigurationException("Unsupported browser: '" + text + "'. Supported options are: CHROME, FIREFOX, EDGE.");
    }

    }


