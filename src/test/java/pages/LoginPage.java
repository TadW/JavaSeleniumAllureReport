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

    private final By enterEmail = By.id("ap_email");
    private final By continueBtn = By.id("continue");
    private final By enterPassword = By.id("ap_password");
    private final By signInBtn = By.id("signInSubmit");

    private final By screenshoot = By.id("a-page");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void loginOnTheAccount(){

        driver.findElement(enterEmail).sendKeys("**email**");
        driver.findElement(continueBtn).click();
        driver.findElement(enterPassword).sendKeys("**password**");
        driver.findElement(signInBtn).click();

        String expected ="Hello, Tad";
        String actual = driver.findElement(By.id("nav-link-accountList-nav-line-1")).getText();

        Assert.assertEquals(expected,actual);
        System.out.println( "excpected:  " + expected   +   " actual: "  +  actual );


    }
    public void takeScreenshot() throws IOException {
        File source = driver.findElement(screenshoot).getScreenshotAs(OutputType.FILE);
        File destination = new File("loginScreenShot.png");
        FileUtils.copyFile(source, destination);
    }





}
