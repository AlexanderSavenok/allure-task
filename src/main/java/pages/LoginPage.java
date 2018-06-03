package pages;

import base.PageBase;
import org.openqa.selenium.By;

public class LoginPage extends PageBase {

    private static final By LOGIN_FIELD = By.id("mailbox:login");
    private static final By PASSWORD_FIELD = By.id("mailbox:password");
    private static final By SUBMIT_BUTTON = By.id("mailbox:submit");

    public MainPage login(String login, String password) {
        fillLoginData(login, password);
        clickSubmitButton();
        return new MainPage();
    }

    public void fillLoginData(String login, String password) {
        driver.findElement(LOGIN_FIELD).sendKeys(login);
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
    }

    public void clickSubmitButton() {
        driver.findElement(SUBMIT_BUTTON).click();
    }

    public boolean isSubmitButtonDisplayed() {
        return driver.findElement(SUBMIT_BUTTON).isDisplayed();
    }
}
