package base;

import factory.ConfigDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import java.time.Duration;


public class BaseTest {
    protected WebDriver driver;

    @Before
    public void setUp() {
        String baseUrl = "https://www.saucedemo.com/";

        driver = new ConfigDriverManager().initializerDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get(baseUrl);
    }

    @After
    public void tearDown() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.quit();
    }
}
