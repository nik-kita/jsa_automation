package test_package.unit.user_mode.home;


import main_package.ui.___U_S_E_R___.general_parts.home.HomeHeaderPart;
import main_package.ui.___U_S_E_R___.general_parts.home.HomePart;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.engine.test_engine.OnixUiAssert;
import main_package.engine.OnixLocator;
import main_package.ui.___U_S_E_R___.page_objects.home_header.home.Home;
import main_package.ui.___U_S_E_R___.page_objects.home_header.UserCabinetDropdown;
import main_package.engine.test_engine.JsaLoginBaseUiTestRunner;

public class HomeUiTest extends JsaLoginBaseUiTestRunner {



    @Test(dataProvider = "getHomeLoginModeLocators")
    public void homeLoginModeTest(OnixLocator locator) {
        onixUiAssert.checkCountOfElementByLocator(locator, 1);
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
        new OnixUiAssert(driver).checkCountOfElementByLocator(locator, 1);
    }

    @DataProvider
    public Object[] getUserCabinetDropdownLocators() {
        return UserCabinetDropdown.Locator.values();
    }

}
