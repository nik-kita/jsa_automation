package ui.guest_mode.main.login;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ui.OnixAssert;
import ui.OnixTestRunner;
import ui.engine.OnixLocator;
import ui.guest_mode.page_objects.main.login.CreateAccount;

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
