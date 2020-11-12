package main_package.ui.guest_mode.main.login;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test_package.test_engine.OnixTestRunner;
import main_package.ui.engine.OnixLocator;
import main_package.ui.guest_mode.page_objects.main.login.CreateAccount;

public class CreateAccountTest extends OnixTestRunner {
    @BeforeClass
    public void goCreateAccount() {
        openSite().goCreateAccountPage();
    }

    @Test(dataProvider = "getCreateAccountLocators")
    public void joinNowPageTest(OnixLocator locator) {
        onixAssert.checkCountOfElementByLocator(locator, 1);
    }

    @DataProvider
    public Object[] getCreateAccountLocators() {
        return CreateAccount.Locator.values();
    }
}
