package test_package.unit.guest_mode.main.login;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.engine.test_engine.OnixUiTestRunner;
import main_package.engine.OnixLocator;
import main_package.ui.___G_U_E_S_T___.page_objects.main.login.Login;

public class LoginPageUiTest extends OnixUiTestRunner {
    @BeforeClass
    public void goLoginPage() {
        openSite().clickHeaderLogin();
    }

    @Test(dataProvider = "getLoginPageLocators")
    public void loginPageTest(OnixLocator locator) {
        onixUiAssert.checkCountOfElementByLocator(locator, 1);
    }

    @DataProvider
    public Object[] getLoginPageLocators() {
        return Login.Locator.values();
    }
}
