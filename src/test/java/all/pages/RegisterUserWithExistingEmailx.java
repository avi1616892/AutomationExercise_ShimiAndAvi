package all.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterUserWithExistingEmailx extends BasePage {

    public RegisterUserWithExistingEmailx(WebDriver driver, int timeout) {
        super(driver, timeout);
    }

    // צעד 3
    public boolean homePageVisible() {
        return isTabTitleMatch("Automation Exercise");
    }

    // צעד 4
    public void clickSignup() {
        click(By.xpath("//a[@href='/login']")); //a[@href='/login']
    }

    // צעד 5
    public boolean validateNewUserSignupVisible() {
        return validateElementExist(By.xpath("//*[text()='New User Signup!']")); //*[text()='New User Signup!']
    }

    // צעד 6
    public void enterNameAndEmail(String name, String email) {
        typeText(By.xpath("//input[@data-qa='signup-name']"), name); //input[@data-qa='signup-name']
        typeText(By.xpath("//input[@data-qa='signup-email']"), email); //input[@data-qa='signup-email']
    }

    // צעד 7
    public void clickSignupButton() {
        click(By.xpath("//button[@data-qa='signup-button']")); //button[@data-qa='signup-button']
    }

    // צעד 8
    public boolean validateEmailExistsError() {
        return validateElementExist(By.xpath("//*[text()='Email Address already exist!']"));
    }
}
