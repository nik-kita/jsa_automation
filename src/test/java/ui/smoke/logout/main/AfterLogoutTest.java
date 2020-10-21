package ui.smoke.logout.main;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ui.OnixAssert;
import ui.OnixTestRunner;
import ui.data.User;
import ui.engine.OnixLocator;

import ui.guest_mode.general_parts.MainHeader;
import ui.guest_mode.page_objects.AfterLogout;

public class AfterLogoutTest extends OnixTestRunner {
    AfterLogout afterLogout;
    @BeforeClass
    public void goAfterLogoutPage() {
        afterLogout = openSite().goLoginPage().login(User.getValidUser()).openUserDropDown().logout();
    }
    @Test(dataProvider = "getAfterLogoutPageLocators")
    public void afterLogoutTest(OnixLocator locator) {
        new OnixAssert(driver).checkCountOfElementByLocator(locator, 1);
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
