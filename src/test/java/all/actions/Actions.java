package all.actions;

import all.pages.HomePage;
import all.pages.LoginPage;
import all.pages.SignUpSignInPage;
import all.utils.JsonUtils;
import org.openqa.selenium.WebDriver;

public class Actions {

    // כאן חגאי יוצר צעדים ממשיים בקוד !!! , זאת אומרת כאן יושב התסריט עצמו וב - SUITE אנחנו סך הכל קוראים לתסריט
    HomePage homePage;
    LoginPage loginPage;
    SignUpSignInPage signUpSignInPage;

    /**
     * Constructor to initialize the Actions class with a WebDriver instance.
     *
     * @param driver the WebDriver instance to be used for interacting with web elements
     */
    public Actions(WebDriver driver) {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        signUpSignInPage = new SignUpSignInPage(driver);
    }

    public boolean verifyHomePage() {
        return homePage.verifyHomePage();
    }

    public boolean verifyLoginPage() {
        boolean results = homePage.verifyHomePage();
        if (results) {
            homePage.clickSignUpLogin();
            results = homePage.verifySignUpLoginPage();
        }
        return results;
    }

    public boolean verifyLoggedInAsUserName(String username) {
        boolean result = homePage.verifySignUpLoginPage();
        if (result) {
            loginPage.typeLoginEmailAndPassword(JsonUtils.readJsonFromFile("valid_email"), JsonUtils.readJsonFromFile("valid_password"));
            loginPage.clickLogin();
            result = loginPage.verifyLoggedInAsUsername(username);
        }
        return result;
    }

    public boolean verifyNavigatedToLoginPage() {
        homePage.clickLogout();
        return homePage.verifySignUpLoginPage();
    }
}
