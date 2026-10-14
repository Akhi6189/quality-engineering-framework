package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class HeaderFooterPage extends BasePage {

    // Header Elements
    private final By currencyDropdown = By.id("customerCurrency");
    private final By registerButton = By.cssSelector("a.ico-register");
    private final By loginButton = By.cssSelector("a.ico-login");
    private final By wishlistButton = By.cssSelector("a.ico-wishlist");
    private final By shoppingCartButton = By.cssSelector("a.ico-cart");
    private final By categoryHeaderText = By.cssSelector("div[class='page-title'] h1");

    // Navigation & Categories Elements
    private final By searchBox = By.id("small-searchterms");
    private final By searchButton = By.cssSelector("a.button-1.search-box-button");
    // Footer Elements
    private final By footerMenu = By.cssSelector(".footer");


    //Action Methods for Header Elements
    protected By getCategoryLocator(String categoryName) {
        String cssSelector = String.format(".menu__link[href='/%s']", categoryName.toLowerCase());
        return By.cssSelector(cssSelector);
    }
    protected By getSubCategoryLocator(String subCategoryName) {
        String cssSelector = String.format("a[href$='/%s']", subCategoryName.toLowerCase());
        return By.cssSelector(cssSelector);
    }
    protected By getFooterLinkLocator(String linkText) {
        String xpath = String.format("//div[@class='footer-menu__item']//a[normalize-space(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'))='%s']",
                linkText.toLowerCase());
        return By.xpath(xpath);
    }
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
    public String clickCategory(String categoryName) {
        By categoryLocator = getCategoryLocator(categoryName);
        click(categoryLocator);
        return getElementText(categoryHeaderText);
    }
    public String clickSubCategory(String subCategoryName) {
        By subCategoryLocator = getSubCategoryLocator(subCategoryName);
        moveToElement(subCategoryLocator);
        click(subCategoryLocator);
        return getElementText(categoryHeaderText);
    }
    public String clickFooterLink(String linkText) {
        By footerLinkLocator = getFooterLinkLocator(linkText);
        click(footerLinkLocator);
        return getElementText(categoryHeaderText);

    }


}
