package all.pages;

import all.utils.JsonUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver, 10);
    }

    public void typeLoginEmailAndPassword(String email, String password) {
        typeText(By.xpath("//input[@data-qa=\"login-email\"]"), email);
        typeText(By.xpath("//input[@data-qa=\"login-password\"]"), password);
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
}
