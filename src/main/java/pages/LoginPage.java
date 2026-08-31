package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.WaitUtils;

public class LoginPage {

    private WaitUtils waitUtils;

    private By username =
            By.cssSelector("[data-test='username']");

    private By password =
            By.cssSelector("[data-test='password']");

    private By loginButton =
            By.cssSelector("[data-test='login-button']");

    public LoginPage(WebDriver driver) {
        waitUtils = new WaitUtils(driver);
    }

    public void login(String user, String pass) {

        waitUtils.enterText(username, user);
        waitUtils.enterText(password, pass);
        waitUtils.click(loginButton);
        waitUtils.waitForUrl("inventory.html");
    }
}
