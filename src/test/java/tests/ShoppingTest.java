package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductsPage;

public class ShoppingTest extends BaseTest {

    @Test
    public void verifyCompletePurchase() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                "standard_user",
                "secret_sauce"
        );

        ProductsPage productsPage =
                new ProductsPage(driver);

        Assert.assertTrue(
                productsPage.isProductsPageDisplayed(),
                "Products page was not displayed"
        );

        productsPage.addBackpackToCart();
        productsPage.openCart();

        CartPage cartPage = new CartPage(driver);

        Assert.assertTrue(
                cartPage.isProductAdded(),
                "Product was not added to cart"
        );

        cartPage.clickCheckout();

        CheckoutPage checkoutPage =
                new CheckoutPage(driver);

        checkoutPage.enterCustomerDetails(
                "Satish",
                "Anadasu",
                "500001"
        );

        checkoutPage.clickContinue();
        checkoutPage.clickFinish();

        Assert.assertEquals(
                checkoutPage.getSuccessMessage(),
                "Thank you for your order!"
        );
    }
}
