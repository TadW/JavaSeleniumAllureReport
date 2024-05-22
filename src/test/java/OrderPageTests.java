import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.OrderPage;

public class OrderPageTests extends BaseTest {

    @Test
    public void successfulOrderAndPayment() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginOnTheAccount();
        OrderPage orderPage = new OrderPage(driver);
        orderPage.paymentAndOrder();

    }

}
