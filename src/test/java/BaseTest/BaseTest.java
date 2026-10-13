package BaseTest;

import config.ConfigReader;
import constants.ConfigConstant;
import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void BrowserSetup() {
    String targetBrowser = ConfigReader.getProperty(ConfigConstant.BROWSER);
    DriverFactory.initializeDriver(targetBrowser);
    this.driver = DriverFactory.getDriver();
    driver.manage().window().maximize();
    driver.get(ConfigReader.getProperty(ConfigConstant.URL));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverFactory.quitDriver();

    }



}
