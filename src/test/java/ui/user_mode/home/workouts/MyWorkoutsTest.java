package ui.user_mode.home.workouts;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ui.OnixAssert;
import ui.engine.OnixLocator;
import ui.user_mode.JsaLoginBaseTestRunner;
import ui.user_mode.general_parts.home.HomeHeaderPart;
import ui.user_mode.general_parts.home.HomePart;
import ui.user_mode.page_objects.home.workouts.MyWorkouts;

public class MyWorkoutsTest extends JsaLoginBaseTestRunner {
    @BeforeClass
    public void goMyWorkoutsPage() {
        homeLoginModePO.clickWorkoutsTab().clickMyWorkoutsTab();
    }
    @Test(dataProvider = "getMyWorkoutsLocators")
    public void myWorkoutsTest(OnixLocator locator) {
        new OnixAssert(driver).checkCountOfElementByLocator(locator, 1);
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
