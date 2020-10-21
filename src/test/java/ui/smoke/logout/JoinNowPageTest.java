package ui.smoke.logout;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ui.OnixAssert;
import ui.OnixTestRunner;
import ui.engine.OnixLocator;
import ui.guest_mode.page_objects.main.create_account.CreateAccount;

public class JoinNowPageTest extends OnixTestRunner {
    @BeforeClass
    public void goJoinNowPage() {
        openSite().goJoinNowPage();
    }

    @Test(dataProvider = "getJoinNowLocators")
    public void joinNowPageTest(OnixLocator locator) {
        new OnixAssert(driver).checkCountOfElementByLocator(locator, 1);
    }

    @DataProvider
    public Object[] getJoinNowLocators() {
        return CreateAccount.Locator.values();
    }
}
