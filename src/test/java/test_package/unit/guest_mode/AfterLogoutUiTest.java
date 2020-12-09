package test_package.unit.guest_mode;

import main_package.engine.test_engine.OnixUiTestRunner;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.ui.data.User;
import main_package.engine.OnixLocator;

import main_package.ui.___G_U_E_S_T___.page_objects.AfterLogout;

public class AfterLogoutUiTest extends OnixUiTestRunner {
    AfterLogout afterLogout;
    @BeforeClass
    public void goAfterLogoutPage() {
        afterLogout = openSite().clickHeaderLogin().login(User.getValidUser()).openUserDropDown().logout();
    }
    @Test(dataProvider = "getAfterLogoutPageLocators")
    public void afterLogoutTest(OnixLocator locator) {
        onixUiAssert.checkCountOfElementByLocator(locator, 1);
    }
    @DataProvider
    public Object[] getAfterLogoutPageLocators() {
        return mergeArrays(
                AfterLogout.FooterLocator.values(),
                AfterLogout.HeaderLocator.values(),
                new OnixLocator[]{afterLogout.successLogoutMessage}
        );
    }
}
