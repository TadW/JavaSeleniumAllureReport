package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static base.BaseTest.extentTest;

public class OrderPage extends BasePage {

    private final By addToCart = By.id("add-to-cart-sauce-labs-backpack");
    private final By gotoShoppingCart = By.id("shopping_cart_container");
    private final By checkout = By.id("checkout");
    private final By firstName = By.id("first-name");
    private final By lastName = By.id("last-name");
    private final By PostalCode = By.id("postal-code");
    private final By continueCheckout = By.id("continue");
    private final By finsihOrder = By.id("finish");


    public OrderPage(WebDriver driver) {
        super(driver);
    }


    public void paymentAndOrder() {
        driver.findElement(addToCart).click();
        driver.findElement(gotoShoppingCart).click();
        driver.findElement(checkout).click();
        driver.findElement(firstName).sendKeys("firstName");
        driver.findElement(lastName).sendKeys("lastName");
        driver.findElement(PostalCode).sendKeys("123456");
        driver.findElement(continueCheckout).click();
        driver.findElement(finsihOrder).click();
        boolean isVisibleMessage = driver.findElement(By.id("back-to-products")).isDisplayed();
        extentTest.info("successful payment and order");

        String expected = "Thank you for your order!";
        String actual = driver.findElement(By.cssSelector(".complete-header")).getText();

        Assert.assertEquals(expected, actual);
        System.out.println("expected: " + expected + "    actual: " + actual);
        Assert.assertTrue(isVisibleMessage);
        extentTest.pass("Assertion is passed");


    }
}
