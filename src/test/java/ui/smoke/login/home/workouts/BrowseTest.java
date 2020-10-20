package ui.smoke.login.home.workouts;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ui.OnixAssert;
import ui.engine.OnixLocator;
import ui.smoke.login.JsaLoginBaseTestRunner;
import ui.user_mode.general_parts.home.HomeHeaderPart;
import ui.user_mode.general_parts.home.HomePart;
import ui.user_mode.page_objects.home.workouts.Browse;

public class BrowseTest extends JsaLoginBaseTestRunner {
    @BeforeClass
    public void goBrowsePage() {
        homeLoginModePO.clickWorkoutsTab().clickBrowseTab();
    }
    @Test(dataProvider = "getBrowseLocators")
    public void browseTest(OnixLocator locator) {
        new OnixAssert(driver).checkCountOfElementByLocator(locator, 1);
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
