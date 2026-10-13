package base;

import config.ConfigReader;
import constants.ConfigConstant;
import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriverWait getWait() {
        int timeout = ConfigReader.getIntProperty(ConfigConstant.EXPLICIT_WAIT);
        return new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(timeout));
    }

    protected WebElement findElement(By locator) {
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void click(By locator) {
        getWait().until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
    protected void sendKeys(By locator, String text) {
        WebElement element = getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(text);
    }
    protected String getElementText(By locator) {
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }

}
