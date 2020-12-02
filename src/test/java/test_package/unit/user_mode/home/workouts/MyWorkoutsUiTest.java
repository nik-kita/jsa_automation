package test_package.unit.user_mode.home.workouts;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.engine.test_engine.OnixUiAssert;
import main_package.engine.OnixLocator;
import main_package.ui.user_mode.general_parts.home.HomeHeaderPart;
import main_package.ui.user_mode.general_parts.home.HomePart;
import main_package.ui.user_mode.page_objects.home_header.workouts.MyWorkouts;
import main_package.engine.test_engine.JsaLoginBaseUiTestRunner;

public class MyWorkoutsUiTest extends JsaLoginBaseUiTestRunner {
    @BeforeClass
    public void goMyWorkoutsPage() {
        homeLoginModePO.clickWorkoutsTab().clickMyWorkoutsTab();
    }
    @Test(dataProvider = "getMyWorkoutsLocators")
    public void myWorkoutsTest(OnixLocator locator) {
        new OnixUiAssert(driver).checkCountOfElementByLocator(locator, 1);
    }
    @DataProvider
    public Object[] getMyWorkoutsLocators() {
        return mergeArrays(
                HomeHeaderPart.HomeHeaderLocator.values(),
                HomePart.HomeFlyLocator.values(),
                MyWorkouts.Locator.values()
        );
    }
}
