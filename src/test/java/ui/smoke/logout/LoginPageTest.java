package ui.smoke.logout;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ui.OnixAssert;
import ui.OnixTestRunner;
import ui.engine.OnixLocator;
import ui.guest_mode.page_objects.Login;

public class LoginPageTest extends OnixTestRunner {
    @BeforeClass
    public void goLoginPage() {
        openSite().goLoginPage();
    }

    @Test(dataProvider = "getLoginPageLocators")
    public void loginPageTest(OnixLocator locator) {
        new OnixAssert(driver).checkCountOfElementByLocator(locator, 1);
    }

    @DataProvider
    public Object[] getLoginPageLocators() {
        return Login.Locator.values();
    }
}
