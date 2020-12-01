package main_package.ui.guest_mode.main.login;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.engine.test_engine.OnixUiTestRunner;
import main_package.engine.OnixLocator;
import main_package.ui.guest_mode.page_objects.main.login.CreateAccount;

public class CreateMyPlanUiTest extends OnixUiTestRunner {
    @BeforeClass
    public void goCreateAccount() {
        openSite().clickJoinNowHeaderButton();
    }

    @Test(dataProvider = "getCreateAccountLocators")
    public void joinNowPageTest(OnixLocator locator) {
        onixUiAssert.checkCountOfElementByLocator(locator, 1);
    }

    @DataProvider
    public Object[] getCreateAccountLocators() {
        return CreateAccount.Locator.values();
    }
}
