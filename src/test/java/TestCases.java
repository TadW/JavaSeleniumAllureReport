import base.BaseTest;
import org.junit.Test;
import pages.LoginPage;


public class TestCases extends BaseTest {


    @Test
    public void loginAccount() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.unsuccessfuLoginIncorrectUser();
        loginPage.unsuccessfuLoginIncorrectPassword();
        loginPage.loginOnTheAccount();


    }


}
