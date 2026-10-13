package driver;

import Exceptions.ConfigurationException;
import enums.BrowserTypes;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverFactory {

   private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();


   private DriverFactory() {
      // Private constructor to prevent instantiation
   }

   public static void initializeDriver(String browserName) {
      BrowserTypes browser = BrowserTypes.fromString(browserName);
      WebDriver driver;
      switch (browser) {
         case CHROME:
            driver = new ChromeDriver();
            break;
         case FIREFOX:
            driver = new FirefoxDriver();
            break;
         case EDGE:
            driver = new EdgeDriver();
            break;
         default:
            throw new ConfigurationException("Unsupported browser: '" + browserName + "'. Supported options are: CHROME, FIREFOX, EDGE.");
      }
      driverThreadLocal.set(driver);


   }

   public static WebDriver getDriver() {
      WebDriver driver = driverThreadLocal.get();
      if (driver == null) {
         throw new ConfigurationException("WebDriver has not been initialized. Call initializeDriver() first.");
      }
      return driver;
   }
   public static void quitDriver() {
      WebDriver driver = driverThreadLocal.get();
      if (driver != null) {
        try {
          driver.quit();
        } finally {
          driverThreadLocal.remove();
        }
      }
   }

}
