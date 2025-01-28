package all.pages;

import all.utils.JsonUtils;
import all.utils.RandomUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpLoginPage extends BasePage {

    public SignUpLoginPage(WebDriver driver) {
        super(driver, 10);
    }

    public void typeLoginEmailAndPassword(String email, String password) {
        typeText(By.xpath("//input[@data-qa=\"login-email\"]"), email);
        typeText(By.xpath("//input[@data-qa=\"login-password\"]"), password);
    }

    public void typeSignUpEmailAndPassword(String email) {
        String name = "user" + RandomUtils.getRandomInt(4);
        typeText(By.xpath("//input[@data-qa=\"signup-name\"]"), name);
        typeText(By.xpath("//input[@data-qa=\"signup-email\"]"), email);
    }

    public void clickSignUp() {
        click(By.xpath("//button[@data-qa=\"signup-button\"]"));
    }

    public void clickLogin() {
        click(By.xpath("//button[@data-qa=\"login-button\"]"));
    }

    public boolean verifyLoggedInAsUsername(String expectedUsername) {
        String expectedUserName = JsonUtils.readJsonFromFile("valid_name");

        boolean isLoggedInTextPresent = validateElementExist(By.xpath("//a[text()=' Logged in as ']"));
        boolean isUsernamePresent = validateElementExist(By.xpath("//b[text()='" + expectedUserName + "']"));

        return isLoggedInTextPresent && isUsernamePresent;
    }

    public boolean verifySignUpLoginPage() {
        boolean login = validateElementExist(By.xpath("//h2[text()='Login to your account']"));
        boolean signUp = validateElementExist(By.xpath("//h2[text()='New User Signup!']"));
        return login && signUp;
    }

    public boolean isEmailAddressAlreadyExistsErrorVisible() {
        return validateElementExist(By.xpath("//p[text()='Email Address already exist!']")); //p[style*="color: red"]
    }
}
