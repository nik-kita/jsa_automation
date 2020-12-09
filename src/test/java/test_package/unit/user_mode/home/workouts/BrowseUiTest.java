package test_package.unit.user_mode.home.workouts;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.engine.OnixLocator;
import main_package.ui.___U_S_E_R___.general_parts.home.HomeHeader;
import main_package.ui.___U_S_E_R___.general_parts.home.HomePart;
import main_package.ui.___U_S_E_R___.page_objects.home_header.workouts.Browse;
import main_package.engine.test_engine.JsaLoginBaseUiTestRunner;

public class BrowseUiTest extends JsaLoginBaseUiTestRunner {
    @BeforeClass
    public void goBrowsePage() {
        homeLoginModePO.clickWorkoutsTab().clickBrowseTab();
    }
    @Test(dataProvider = "getBrowseLocators")
    public void browseTest(OnixLocator locator) {
        onixUiAssert.checkCountOfElementByLocator(locator, 1);
    }
    @DataProvider
    public Object[] getBrowseLocators() {
        return mergeArrays(
                HomePart.HomeFlyLocator.values(),
                HomeHeader.HomeHeaderLocator.values(),
                Browse.Locator.values()
        );
    }
}
