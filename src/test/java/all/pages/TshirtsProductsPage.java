package all.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class TshirtsProductsPage extends BasePage {

    public TshirtsProductsPage(WebDriver driver) {
        super(driver, 10);
    }

    public boolean verifyMenDressProductsText() {
        return isTabTitleMatch("Automation Exercise - Tshirts Products");
    }
}
