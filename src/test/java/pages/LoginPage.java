package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static base.BaseTest.extentTest;

public class LoginPage extends BasePage {

    private final By enterUser = By.id("user-name");
    private final By enterPassword = By.id("password");
    private final By signInBtn = By.id("login-button");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void loginOnTheAccount() {
        driver.findElement(enterUser).clear();
        driver.findElement(enterUser).sendKeys("standard_user");
        driver.findElement(enterPassword).clear();
        driver.findElement(enterPassword).sendKeys("secret_sauce");
        driver.findElement(signInBtn).click();
        extentTest.info("successful login").getStatus();

        String expected = "Swag Labs";
        String actual = driver.findElement(By.cssSelector(".app_logo")).getText();

        Assert.assertEquals(expected, actual);
        System.out.println("expected:  " + expected + " actual: " + actual);
        extentTest.pass("Assertion is passed");

    }

    public void unsuccessfuLoginIncorrectUser() {

        driver.findElement(enterUser).clear();
        driver.findElement(enterUser).sendKeys("incorrect_user");
        driver.findElement(enterPassword).clear();
        driver.findElement(enterPassword).sendKeys("secret_sauce");
        driver.findElement(signInBtn).click();
        boolean isVisibleErrorMessage = driver.findElement(By.cssSelector(".error-button")).isDisplayed();
        extentTest.info("unsuccessfu login incorrect user");

        Assert.assertTrue(isVisibleErrorMessage);
        extentTest.pass("Assertion is passed");
    }

    public void unsuccessfuLoginIncorrectPassword() {

        driver.findElement(enterUser).clear();
        driver.findElement(enterUser).sendKeys("standard_user");
        driver.findElement(enterPassword).clear();
        driver.findElement(enterPassword).sendKeys("incorrect_password");
        driver.findElement(signInBtn).click();
        boolean isVisibleErrorMessage = driver.findElement(By.cssSelector(".error-button")).isDisplayed();
        extentTest.info("unsuccessfu login incorrect password");

        Assert.assertTrue(isVisibleErrorMessage);
        extentTest.pass("Assertion is passed");
    }
}
