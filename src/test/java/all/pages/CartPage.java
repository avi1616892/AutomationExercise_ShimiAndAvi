package all.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver, 10);
    }

    public boolean verifyCartPage() {
        return isTabTitleMatch("Automation Exercise - Checkout");
    }

    public boolean validateSubscriptionTextVisible() {
        scrollToElement(By.xpath("//h2[text()='Subscription']"));
        return validateElementExist(By.xpath("//h2[text()='Subscription']"));
    }

    public void enterEmailAndSubscribe(String email) {
        typeText(By.xpath("//input[@type='email']"), email);
        click(By.xpath("//button[@type='submit']"));
    }

    public boolean validateSuccessSubscriptionMessage() {
        return validateElementExist(By.xpath("//*[contains(text(),'You have been successfully subscribed!')]"));
    }
}

