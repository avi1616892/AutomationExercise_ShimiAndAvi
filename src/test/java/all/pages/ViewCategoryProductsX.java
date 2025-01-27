package all.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ViewCategoryProductsX extends BasePage {

    public ViewCategoryProductsX(WebDriver driver, int timeout) {
        super(driver, 10);
    }

    // צעד 3
    public boolean validateCategoriesVisible() {
        return validateElementExist(By.xpath("//div[@class='left-sidebar']"));
    }

    // צעד 4
    public void clickWomenCategory() {
        click(By.xpath("//a[text()='Women']")); //a[text()='Women']
    }

    // צעד 5
    public void clickCategoryLink(String categoryName) {
        click(By.xpath("//a[text()='Dress']"));
    }

    // צעד 6
    public boolean validateCategoryPageDisplayed() {
        return validateElementExist(By.xpath("//*[contains(text(),'WOMEN - TOPS PRODUCTS')]"));
    }

    // צעד 7
    public void clickSubCategoryLinkUnderMen(String subCategoryName) {
        click(By.xpath("//a[text()='T-Shirts']" ));
    }

    // צעד 8
    public boolean validateNavigatedToCategoryPage() {
        return validateElementExist(By.xpath("//h2[text()='Men - Tshirts Products']"));
    }
}
