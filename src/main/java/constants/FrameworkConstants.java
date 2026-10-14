package constants;
import Exceptions.ConfigurationException;
public class FrameworkConstants {

    private FrameworkConstants() {
        // Private constructor to prevent instantiation
    }

    // Config file selections
    public static final String DEFAULT_ENV = "qa";
    public static final String ENV_PROPERTY = "env";
    public static final int CON_TIMEOUT = 3000;
}
