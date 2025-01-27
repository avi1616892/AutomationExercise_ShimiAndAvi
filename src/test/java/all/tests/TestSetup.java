package all.tests;

import all.utils.GenerateDriver;
import org.openqa.selenium.WebDriver;

public class TestSetup {
    public static void main(String[] args) {
        String configFilePath = "./RunParams.json";

        // Initialize WebDriver using configuration file
        WebDriver driver = GenerateDriver.initDriverFromConfig(configFilePath);

        // Perform your test steps here
        System.out.println("Title: " + driver.getTitle());

        // Clean up
        GenerateDriver.cleanDriver(driver);
    }
}
