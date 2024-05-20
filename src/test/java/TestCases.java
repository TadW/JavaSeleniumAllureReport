import base.BaseTest;
import org.junit.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;
import java.io.IOException;

public class TestCases extends BaseTest {


    @Test
    public void createAccount() throws IOException {

        HomePage homePage = new HomePage(driver);
        RegisterPage registerPage = homePage.clickNewCoustomerLink();
        registerPage.clickcreateAccountSubmit();
        registerPage.fillOutRegistrationForm();

        registerPage.takeScreenshot();

    }

    @Test
    public void loginAccount() throws IOException {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickNavigateToLogin();
        loginPage.loginOnTheAccount();

        loginPage.takeScreenshot();


    }


}
