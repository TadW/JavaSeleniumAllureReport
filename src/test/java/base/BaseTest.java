package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import factory.ConfigDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.time.Duration;


public class BaseTest {
    protected WebDriver driver;
    public static ExtentReports extentReports;
    public static ExtentTest extentTest;


    @Parameters("browserName")
    @BeforeTest
    public void setUp(ITestContext context, @Optional("chrome") String browserName) throws IOException {

        String baseUrl = "https://www.saucedemo.com/";
        driver = new ConfigDriverManager().initializerDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(baseUrl);

        extentTest = extentReports.createTest(context.getName());

    }

    @AfterTest
    public void tearDown() {
        driver.quit();

    }

    @BeforeSuite
    public void initExtentReports() {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("extentReportTests.html");

        extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);
        sparkReporter.config().setTheme(Theme.DARK);
        extentReports.createTest("Test Failed! <i class='fa fa-frown-o'></i>")
                .fail(new RuntimeException("A runtime exception occurred!"));
    }

    @AfterSuite
    public void generateReport() {
        extentReports.flush();
    }
}
