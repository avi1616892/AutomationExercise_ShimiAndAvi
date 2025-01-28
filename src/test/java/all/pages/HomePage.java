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

    public void clickLogout() {
        click(By.xpath("//a[@href='/logout']"));
    }

    public void clickCart() {
        click(By.xpath("//*[text()=' Cart']"));
    }

    public void verifyCategoriesInLeftSidebar() {
        validateElementExist(By.xpath("//div[@class='left-sidebar']//h2[text()='Category']"));
    }

    public void clickWomanCategory() {
        click(By.xpath("//a[@data-toggle='collapse' and @href='#Women']"));
    }

    public void clickDressSubCategory() {
        click(By.xpath("//a[@href='/category_products/1']"));
    }

}


