package utils;

import base.BasePage;
import constants.FrameworkConstants;
import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.List;

public class LinkValidation extends BasePage {

        public void verifyAllFooterLinks() {
            List<WebElement> footerLinks = DriverFactory.getDriver().findElements(By.cssSelector(".footer-upper"));
            for (WebElement link : footerLinks) {
                String urlString = link.getAttribute("href");
                if (urlString == null || urlString.isEmpty() || urlString.startsWith("javascript:") || urlString.startsWith("mailto:")) {
                    continue;
                }
                try {
                    URL url = URI.create(urlString).toURL();
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(FrameworkConstants.CON_TIMEOUT);
                    connection.connect();

                    int responseCode = connection.getResponseCode();
                    if (responseCode >= 400) {
                        System.out.println("BROKEN LINK: " + urlString + " | Response Code: " + responseCode);
                    } else {
                        System.out.println("VALID LINK: " + urlString + " | Response Code: " + responseCode);
                    }
                } catch (Exception e) {
                    System.out.println("⚠️ ERROR checking link: " + urlString + " - " + e.getMessage());
                }
            }
        }
    }

