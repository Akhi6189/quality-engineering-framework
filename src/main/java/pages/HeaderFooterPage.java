package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import java.sql.DriverManager;

public class HeaderFooterPage extends BasePage {

    // Header Elements
    private final By currencyDropdown = By.id("customerCurrency");
    private final By registerButton = By.cssSelector("a.ico-register");
    private final By loginButton = By.cssSelector("a.ico-login");
    private final By wishlistButton = By.cssSelector("a.ico-wishlist");
    private final By shoppingCartButton = By.cssSelector("a.ico-cart");

    // Navigation & Categories Elements
    private final By searchBox = By.id("small-searchterms");
    private final By searchButton = By.cssSelector("a.button-1 search-box-button");
    private final By menuCategory = By.cssSelector(".menu");

    // Footer Elements
    private final By footerMenu = By.cssSelector(".footer");


    //Action Methods for Header Elements
    public void selectCurrency(String currency) {
        Select currencySelect = new Select(findElement(currencyDropdown));
        currencySelect.selectByVisibleText(currency);
    }
    public void clickRegister() {
        click(registerButton);
    }
    public void clickLogin() {
        click(loginButton);
    }
    public void clickWishlist() {
        click(wishlistButton);
    }
    public void clickShoppingCart() {
        click(shoppingCartButton);
    }
    public void clickSearchBox(String text) {
        sendKeys(searchBox, text);
        click(searchButton);
    }







}
