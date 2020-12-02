package test_package.unit.user_mode.home.account.my_profile;

import main_package.engine.OnixLocator;

import main_package.ui.user_mode.general_parts.home.account.AccountHeader;
import main_package.ui.user_mode.page_objects.home_header.home.account.my_profile.EmailPreferences;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.engine.test_engine.JsaLoginBaseUiTestRunner;

public class EmailPreferencesUiTest extends JsaLoginBaseUiTestRunner {
    @BeforeClass
    public void openEmailPreferences() {
        homeLoginModePO.clickAccountIcon().clickMyProfile().clickUpdateEmailPreferences();
    }
    @Test(dataProvider = "origin")
    public void emailPreferencesTest(OnixLocator locator) {
        onixUiAssert.checkCountOfElementByLocator(locator, 1);
    }
    @DataProvider
    public Object[] origin() {
        return mergeArrays(
                EmailPreferences.Locator.values(),
                AccountHeader.AccountHeaderLocator.values()
        );
    }
}
