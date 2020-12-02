package test_package.unit.user_mode.home.workouts;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.engine.OnixLocator;
import main_package.ui.user_mode.JsaLoginBaseUiTestRunner;
import main_package.ui.user_mode.general_parts.home.HomeHeaderPart;
import main_package.ui.user_mode.general_parts.home.HomePart;
import main_package.ui.user_mode.page_objects.home_header.workouts.Browse;

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
                HomeHeaderPart.HomeHeaderLocator.values(),
                Browse.Locator.values()
        );
    }
}
