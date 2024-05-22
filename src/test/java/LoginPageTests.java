import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;


public class LoginPageTests extends BaseTest {


    @Test
    public void unsuccessfuLoginIncorrectUser() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.unsuccessfuLoginIncorrectUser();

    }

    @Test
    public void unsuccessfuLoginIncorrectPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.unsuccessfuLoginIncorrectPassword();

    }

    @Test(groups = {"smoke"})
    public void successfullLoginCorrectCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginOnTheAccount();

    }

}
