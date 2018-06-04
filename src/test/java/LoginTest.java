import base.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import junit.ScreenshotOnFailureRule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.LoginPage;
import pages.MainPage;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(ScreenshotOnFailureRule.class)
public class LoginTest extends TestBase {

    private final static String LOGIN = "seleniumtests10";
    private final static String PASSWORD = "060788avavav";

    @Description("Login test and verified email list is not empty")
    @Feature("LOGIN")
    @Test
    public void loginMailRuEmailsListIsDisplayedTest() {
        MainPage mainPage = new LoginPage().login(LOGIN, PASSWORD);

        assertAll("Verify inbox elements",
                () -> assertTrue(mainPage.waitInboxHyperlinkDisplayed(), "Inbox hyperlink is not displayed"),
                () -> assertTrue(mainPage.getInboxMailCollection().size() > 0, "Inbox pane is empty")
        );
    }

    @Description("Logout test and verified logout hyperlink is displayed")
    @Feature("LOGIN")
    @Test
    public void loginMailRuLogoutHyperlinkDisplayedTest() {
        MainPage mainPage = new LoginPage().login(LOGIN, PASSWORD);

        assertTrue(mainPage.waitLogoutHyperlinkDisplayed(), "Logout hyperlink is not displayed");

        LoginPage loginPage = mainPage.logout();
        assertTrue(loginPage.isSubmitButtonDisplayed(), "Submit button is not displayed");
    }
}
