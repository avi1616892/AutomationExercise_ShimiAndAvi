package all.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class DressProductsPage extends BasePage {

    public DressProductsPage(WebDriver driver) {
        super(driver, 10);
    }

    public boolean verifyDressProductsPage() {
        return isTabTitleMatch("Automation Exercise - Dress Products");
    }

    public void verifyWomenDressProductsText() {
        validateElementExist(By.xpath("//h2[@class='title text-center' and contains(text(),'Women - Dress Products')]"));
    }

    public void clickMenCategory() {
        click(By.xpath("//a[@data-toggle='collapse' and @href='#Men']"));
    }

    public void clickTShirtsSubCategory() {
        click(By.xpath("//a[@href='/category_products/1']"));
    }

    public void clickHome() {
        click(By.xpath("//*[text()=' Home']"));
    }
}
