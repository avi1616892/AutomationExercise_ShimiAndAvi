package all.tests;

import all.actions.Actions;
import all.utils.GenerateDriver;
import all.utils.JsonUtils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogoutUserSuiteTest {

    private static final Logger logger = LogManager.getLogger(LogoutUserSuiteTest.class);
    WebDriver driver;
    Actions actions;

    // Configuration variables
    String URL = JsonUtils.readJsonFromFile("url");
    String BROWSER = JsonUtils.readJsonFromFile("browser");

    /**
     * Sets up the test environment before running the suite.
     * Initializes WebDriver and Actions instance.
     */
    @BeforeSuite
    public void setUp() {
        driver = GenerateDriver.initDriver(BROWSER, URL);
        actions = new Actions(driver);
    }

    /**
     * Verify that the home page is visible successfully.
     */
    @Test(priority = 1, description = "Testing the visibility of the Home page", groups = {"regression", "LogOutUser"})
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
     * Verify that 'Login to your account' is visible successfully.
     */
    @Test(priority = 2, description = "Testing the visibility of 'Login to your account' message", groups = {"regression", "LogOutUser"})
    public void verifyLoginToYourAccount() {
        boolean result = actions.verifySignUpLoginPage();
        if (result) {
            logger.info("'Login to your account' is visible, test passed.");
        } else {
            logger.error("'Login to your account' is not visible, test failed.");
        }
        Assert.assertTrue(result, "'Login to your account' is not visible.");
    }

    /**
     * Verify that 'Logged in as username' is visible successfully.
     */
    @Test(priority = 3, description = "Testing the visibility of 'Logged in as username' message", groups = {"regression", "LogOutUser"})
    public void verifyLoggedInAsUsername() {
        String username = JsonUtils.readJsonFromFile("valid_name");
        boolean result = actions.verifyLoggedInAsUserName(username);

        if (result) {
            logger.info("'Logged in as {}' is visible, test passed.", username);
        } else {
            logger.error("'Logged in as {}' is not visible, test failed.", username);
        }
        Assert.assertTrue(result, "'Logged in as " + username + "' is not visible.");
    }

    /**
     * Verify that the user is navigated to the login page successfully.
     */
    @Test(priority = 4, description = "Verify that user is navigated to the login page", groups = {"regression", "LogOutUser"})
    public void verifyUserNavigatedToLoginPage() {
        boolean result = actions.verifyNavigatedToLoginPage();

        if (result) {
            logger.info("User successfully navigated to the login page, test passed.");
        } else {
            logger.error("User did not navigate to the login page, test failed.");
        }
        Assert.assertTrue(result, "User is not navigated to the login page.");
    }

    /**
     * Cleans up resources after the suite execution is complete.
     * Quits WebDriver.
     */
    @AfterSuite
    public void tearDown() {
        GenerateDriver.cleanDriver(driver);
    }
}
