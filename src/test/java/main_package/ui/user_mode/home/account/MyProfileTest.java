package main_package.ui.user_mode.home.account;

import main_package.ui.engine.OnixLocator;
import main_package.ui.user_mode.JsaLoginBaseTestRunner;
import main_package.ui.user_mode.general_parts.Footer;
import main_package.ui.user_mode.general_parts.home.account.AccountHeader;
import main_package.ui.user_mode.general_parts.home.account.AccountSidebar;
import main_package.ui.user_mode.page_objects.home_header.home.account.MyProfile;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MyProfileTest extends JsaLoginBaseTestRunner {
    @BeforeClass
    public void openMyProfile() {
        homeLoginModePO.clickAccountIcon().clickMyProfile();
    }
    @Test(dataProvider = "origin")
    public void testMyProfilePage(OnixLocator locator) {
        onixAssert.checkCountOfElementByLocator(locator, 1);
    }
    @DataProvider
    public Object[] origin() {
        return mergeArrays(
                MyProfile.Locator.values(),
                AccountSidebar.AccountSidebarLocator.values(),
                AccountHeader.AccountHeaderLocator.values(),
                Footer.FooterLocator.values()
        );
    }
}
