package all.tests;

import all.actions.Actions;
import all.utils.JsonUtils;
import example1.utils.GenerateDriver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogOutSuiteTest {

    private static final Logger logger = LogManager.getLogger(LogOutSuiteTest.class);
    WebDriver driver;
    Actions actions;

    String URL = JsonUtils.readJsonFromFile("url");
    String BROWSER = JsonUtils.readJsonFromFile("browser");

    @BeforeSuite
    public void setUp() {
        driver = all.utils.GenerateDriver.initDriver(BROWSER, URL);
        actions = new Actions(driver);
    }

    /**
      Testing Verify that home page is visible successfully.
     */
    @Test(priority = 1, description = "testing the Home page", groups = {"smoke", "registration_User"})
    public void verifyHomePage() {
        boolean result = actions.verifyHomePage();
        if (result) {
            logger.info("Home page is visible, test passed.");
        } else {
            logger.error("Home page is not visible, test failed.");
        }
        Assert.assertTrue(result, "The Home page is not visible.");
    }

    /**
     * Testing Verify that 'Login to your account' is visible successfully.
     */
    @Test(priority = 2, description = "Testing the visibility of 'Login to your account' message", groups = {"smoke", "login"})
    public void verifyLoginToYourAccount() {
        boolean result = actions.verifyLoginPage();
        if (result) {
            logger.info("'Login to your account' is visible, test passed.");
        } else {
            logger.error("'Login to your account' is not visible, test failed.");
        }
        Assert.assertTrue(result, "'Login to your account' is not visible.");
    }

    /**
     * Testing Verify that 'Logged in as username' is visible successfully.
     */
    @Test(priority = 3, description = "Testing the visibility of 'Logged in as username' message", groups = {"smoke", "login"})
    public void verifyLoggedInAsUsername() {
        String username = JsonUtils.readJsonFromFile("valid_name");
        boolean result = actions.verifyLoggedInAsUserName(username);

        if (result) {
            logger.info("'Logged in as " + username + "' is visible, test passed.");
        } else {
            logger.error("'Logged in as " + username + "' is not visible, test failed.");
        }
        Assert.assertTrue(result, "'Logged in as " + username + "' is not visible.");
    }

    /**
     * This test case verifies that the user has successfully navigated to the login page.
     * It checks the behavior when the user tries to log in or accesses the login page.
     *
     * It will assert that the login page is displayed correctly by using the verifyNavigatedToLoginPage method.
     */
    @Test(priority = 4, description = "Verify that user is navigated to login page", groups = {"smoke", "login"})
    public void verifyUserNavigatedToLoginPage() {
        boolean result = actions.verifyNavigatedToLoginPage();

        if (result) {
            logger.info("User successfully navigated to the login page, test passed.");
        } else {
            logger.error("User did not navigate to the login page, test failed.");
        }
        Assert.assertTrue(result, "User is not navigated to the login page.");
    }

    @AfterSuite
    public void tearDown() {
        GenerateDriver.cleanDriver(driver);
    }
}
