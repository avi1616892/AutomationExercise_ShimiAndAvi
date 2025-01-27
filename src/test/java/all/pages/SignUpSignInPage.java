package all.pages;

import all.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class SignUpSignInPage extends BasePage {

    // מחגאי

    public SignUpSignInPage(WebDriver driver) {
        super(driver, 10);
    }

    public void typeSignUpName(String name){
        typeText(By.xpath("//input[@data-qa='signup-name']"), name);
    }
    public void typeSignUpEmail(String email){
        typeText(By.xpath("//input[@data-qa='signup-email']"), email);
    }

    public void clickSignUp(){
        click(By.xpath("//button[@data-qa=\"signup-button\"]"));
    }

    public void typeSignInEmail(String email){
        typeText(By.xpath("//input[@data-qa=\"login-email\"]"), email);
    }

    public void typeSignInPassword(String password){
        typeText(By.xpath("//input[@data-qa=\"login-password\"]"), password);
    }

    public void clickSignIn(){
        click(By.xpath("//button[@data-qa=\"login-button\"]"));
    }

    public boolean validateSucceedLogin(String name){
        return getElementText(By.xpath("//b")).equals(name);
    }

    public boolean verifyStartingSignUp(String name, String email){
        boolean result = getElementAttributeUsingJS(By.xpath("//input[@name=\"name\"]"),"value").equals(name);
        if(result){
            result = getElementAttributeUsingJS(By.xpath("//input[@name=\"email\"]"),"value").equals(email);
        }else {
            return false;
        }
        if(result)
            return validateElementExist(By.xpath("//h2/b[text()='Enter Account Information']"));
        return false;
    }
}

