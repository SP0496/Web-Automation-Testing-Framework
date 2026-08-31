package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.WaitUtils;

public class ProductsPage {

    private WaitUtils waitUtils;

    private By pageTitle =
            By.cssSelector("[data-test='title']");

    private By addBackpackButton =
            By.cssSelector(
                "[data-test='add-to-cart-sauce-labs-backpack']"
            );

    private By removeBackpackButton =
            By.cssSelector(
                "[data-test='remove-sauce-labs-backpack']"
            );

    private By cartButton =
            By.cssSelector("[data-test='shopping-cart-link']");

    public ProductsPage(WebDriver driver) {
        waitUtils = new WaitUtils(driver);
    }

    public boolean isProductsPageDisplayed() {
        return waitUtils
                .waitForVisibility(pageTitle)
                .isDisplayed();
    }

    public void addBackpackToCart() {
        waitUtils.click(addBackpackButton);
        waitUtils.waitForVisibility(removeBackpackButton);
    }

    public void openCart() {
        waitUtils.click(cartButton);
        waitUtils.waitForUrl("cart.html");
    }
}