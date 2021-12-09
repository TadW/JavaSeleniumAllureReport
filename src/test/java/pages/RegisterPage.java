package pages;

import base.BasePage;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class RegisterPage extends BasePage {

    private final By createAccountSubmit = By.id("createAccountSubmit");
    private final By nameCostumer = By.id("ap_customer_name");
    private final By emailCostumer = By.id("ap_email");
    private final By password = By.id("ap_password");
    private final By repassword = By.id("ap_password_check");
    private final By continueBtn = By.id("continue");
    private final By emailIsUse = By.className("a-alert-heading");

    private final By screenshoot = By.id("a-page");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void clickcreateAccountSubmit() {
        driver.findElement(createAccountSubmit).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


    }

    public void fillOutRegistrationForm() {
        driver.findElement(nameCostumer).sendKeys("userName");
        driver.findElement(emailCostumer).sendKeys("**email**");
        driver.findElement(password).sendKeys("**password**");
        driver.findElement(repassword).sendKeys("**password**");
        driver.findElement(continueBtn).click();
        driver.findElement(emailIsUse).getText();

        String expected ="Email address already in use";
        //String actual = driver.findElement(By.xpath("//h4[normalize-space()='Email address already in use']")).getText();
        String actual = driver.findElement(By.cssSelector("div[class='a-box a-alert a-alert-warning a-spacing-base'] h4[class='a-alert-heading']")).getText();

        Assert.assertEquals(expected,actual);
        System.out.println("expected: "   + expected    +    "    actual: "  +  actual);



    }

    public void takeScreenshot() throws IOException {
        File source = driver.findElement(screenshoot).getScreenshotAs(OutputType.FILE);
        File destination = new File("registerScreenShot.png");
        FileUtils.copyFile(source, destination);
    }

}
