package all.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ScrollUpAndDownX extends BasePage {

    public ScrollUpAndDownX(WebDriver driver, int timeout) {
        super(driver, 10);
    }

    // צעד 3
    public boolean homePageVisible() {
        return isTabTitleMatch("Automation Exercise");
    }

    // צעד 4
    public void scrollToBottom() {
        scrollToElement(By.xpath("//footer"));
    }

    // צעד 5
    public boolean validateSubscriptionVisible() {
        return validateElementExist(By.xpath("//*[text()='Subscription']"));
    }

    // צעד 6
    public void clickScrollUpArrow() {
        click(By.id("scrollUp"));
    }

    // צעד 7
    public boolean validateScrollUpSuccess() {
        return validateElementExist(By.id("slider-carousel"));
    }
}

