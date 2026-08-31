package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.WaitUtils;

public class CartPage {

    private WaitUtils waitUtils;

    private By backpackName =
            By.cssSelector(
                "[data-test='inventory-item-name']"
            );

    private By checkoutButton =
            By.cssSelector("[data-test='checkout']");

    public CartPage(WebDriver driver) {
        waitUtils = new WaitUtils(driver);
    }

    public boolean isProductAdded() {
        String name = waitUtils.getText(backpackName);
        return name.equals("Sauce Labs Backpack");
    }

    public void clickCheckout() {
        waitUtils.click(checkoutButton);
        waitUtils.waitForUrl("checkout-step-one.html");
    }
}