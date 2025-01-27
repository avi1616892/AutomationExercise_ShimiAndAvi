package all.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver, 10);
    }

    public boolean verifyHomePage() {
        return isTabTitleMatch("Automation Exercise");
    }

    public void clickSignUpLogin() {
        click(By.xpath("//a[@href=\"/login\"]"));
    }

    public boolean verifySignUpLoginPage() {
        boolean login = validateElementExist(By.xpath("//h2[text()='Login to your account']"));
        boolean signUp = validateElementExist(By.xpath("//h2[text()='New User Signup!']"));
        return login && signUp;
    }

    public void clickLogout() {
        click(By.xpath("//a[@href='/logout']"));
    }
}


