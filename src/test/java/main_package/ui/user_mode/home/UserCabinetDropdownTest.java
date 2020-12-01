package main_package.ui.user_mode.home;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.engine.OnixLocator;
import main_package.ui.user_mode.JsaLoginBaseTestRunner;
import main_package.ui.user_mode.page_objects.home_header.UserCabinetDropdown;

public class UserCabinetDropdownTest extends JsaLoginBaseTestRunner {
    @Test(dataProvider = "getUserCabinetDropdownLocators")
    public void userCabinetDropdownTest(OnixLocator locator) {
        homeLoginModePO.openUserDropDown();
        onixUiAssert.checkCountOfElementByLocator(locator, 1);
    }

    @DataProvider
    public Object[] getUserCabinetDropdownLocators() {
        return UserCabinetDropdown.Locator.values();
    }
}
