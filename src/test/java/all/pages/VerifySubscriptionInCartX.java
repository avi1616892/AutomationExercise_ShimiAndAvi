package all.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VerifySubscriptionInCartX extends BasePage {

    public VerifySubscriptionInCartX(WebDriver driver, int timeout) {
        super(driver, 10);
    }

    // צעד 3
    public boolean homePageVisible() {
        return isTabTitleMatch("Automation Exercise");
    }

    // צעד 4
    public void clickCart() {
        click(By.xpath("//a[@href='/view_cart']")); //a[@href='/view_cart']
    }

    // צעד 5
    public void scrollToFooter() {
        scrollToElement(By.xpath("//footer"));
    }

    // צעד 6
    public boolean validateSubscriptionTextVisible() {
        return validateElementExist(By.xpath("//*[text()='SUBSCRIPTION']"));
    }

    // צעד 7
    public void enterEmailAndSubscribe(String email) {
        typeText(By.xpath("//input[@type='email']"), email); //input[@type='email']
        click(By.xpath("//button[@type='submit']")); //button[@type='submit']
    }

    // צעד 8
    public boolean validateSuccessSubscriptionMessage() {
        return validateElementExist(By.xpath("//*[contains(text(),'You have been successfully subscribed!')]"));
    }
}

