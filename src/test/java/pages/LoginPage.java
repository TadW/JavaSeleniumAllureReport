package pages;

import base.BasePage;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;

public class LoginPage extends BasePage {

    private final By enterUser = By.id("user-name");
    private final By enterPassword = By.id("password");
    private final By signInBtn = By.id("login-button");

    private final By screenshoot = By.id("header_container");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void loginOnTheAccount() {
        driver.findElement(enterUser).clear();
        driver.findElement(enterUser).sendKeys("standard_user");
        driver.findElement(enterPassword).clear();
        driver.findElement(enterPassword).sendKeys("secret_sauce");
        driver.findElement(signInBtn).click();

        String expected = "Swag Labs";
        String actual = driver.findElement(By.cssSelector(".app_logo")).getText();

        Assert.assertEquals(expected, actual);
        System.out.println("expected:  " + expected + " actual: " + actual);


    }

    public void unsuccessfuLoginIncorrectUser() {

        driver.findElement(enterUser).sendKeys("incorrect_user");
        driver.findElement(enterPassword).sendKeys("secret_sauce");
        driver.findElement(signInBtn).click();
        boolean isVisibleErrorMessage = driver.findElement(By.cssSelector(".error-button")).isDisplayed();

        Assert.assertTrue(isVisibleErrorMessage);
    }

    public void unsuccessfuLoginIncorrectPassword() {

        driver.findElement(enterUser).clear();
        driver.findElement(enterUser).sendKeys("standard_user");
        driver.findElement(enterPassword).clear();
        driver.findElement(enterPassword).sendKeys("incorrect_password");
        driver.findElement(signInBtn).click();
        boolean isVisibleErrorMessage = driver.findElement(By.cssSelector(".error-button")).isDisplayed();

        Assert.assertTrue(isVisibleErrorMessage);
    }

    public void takeScreenshot() throws IOException {
        File source = driver.findElement(screenshoot).getScreenshotAs(OutputType.FILE);
        File destination = new File("loginScreenShot.png");
        FileUtils.copyFile(source, destination);
    }


}
