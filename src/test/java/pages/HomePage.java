package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private final By newCostumerBtn = By.id("nav-link-accountList-nav-line-1");


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public RegisterPage clickNewCoustomerLink() {
        driver.findElement(newCostumerBtn).click();
        return new RegisterPage(driver);
    }

    public LoginPage clickNavigateToLogin() {
        driver.findElement(newCostumerBtn).click();
        return new LoginPage(driver);
    }

}
