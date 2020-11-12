package main_package.ui.guest_mode;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test_package.test_engine.OnixTestRunner;
import main_package.ui.data.User;
import main_package.ui.engine.OnixLocator;

import main_package.ui.guest_mode.page_objects.AfterLogout;

public class AfterLogoutTest extends OnixTestRunner {
    AfterLogout afterLogout;
    @BeforeClass
    public void goAfterLogoutPage() {
        afterLogout = openSite().goLoginPage().login(User.getValidUser()).openUserDropDown().logout();
    }
    @Test(dataProvider = "getAfterLogoutPageLocators")
    public void afterLogoutTest(OnixLocator locator) {
        onixAssert.checkCountOfElementByLocator(locator, 1);
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
