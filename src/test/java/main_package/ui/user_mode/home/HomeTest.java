package main_package.ui.user_mode.home;


import main_package.ui.user_mode.general_parts.home.HomeHeaderPart;
import main_package.ui.user_mode.general_parts.home.HomePart;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test_package.test_engine.OnixAssert;
import main_package.ui.engine.OnixLocator;
import main_package.ui.user_mode.JsaLoginBaseTestRunner;
import main_package.ui.user_mode.page_objects.home_header.home.Home;
import main_package.ui.user_mode.page_objects.home_header.UserCabinetDropdown;

public class HomeTest extends JsaLoginBaseTestRunner {



    @Test(dataProvider = "getHomeLoginModeLocators")
    public void homeLoginModeTest(OnixLocator locator) {
        onixAssert.checkCountOfElementByLocator(locator, 1);
    }

    @DataProvider
    public Object[] getHomeLoginModeLocators() {
        return mergeArrays(
                Home.Locator.values(),
                HomeHeaderPart.HomeHeaderLocator.values(),
                HomePart.HomeFlyLocator.values()
        );
    }

    @Test(dataProvider = "getUserCabinetDropdownLocators")
    public void userCabinetDropdownTest(OnixLocator locator) {
        homeLoginModePO.openUserDropDown();
        new OnixAssert(driver).checkCountOfElementByLocator(locator, 1);
    }

    @DataProvider
    public Object[] getUserCabinetDropdownLocators() {
        return UserCabinetDropdown.Locator.values();
    }

}
