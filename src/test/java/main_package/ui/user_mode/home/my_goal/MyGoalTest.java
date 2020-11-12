package main_package.ui.user_mode.home.my_goal;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.ui.engine.OnixLocator;
import main_package.ui.user_mode.JsaLoginBaseTestRunner;
import main_package.ui.user_mode.page_objects.home_header.home.my_goal.MyGoal;

public class MyGoalTest extends JsaLoginBaseTestRunner {
    @BeforeClass
    public void goMyGoalPage() {
        homeLoginModePO.clickMyGoalLink();
    }
    @Test(dataProvider = "getMyGoalPageLocators")
    public void myGoalTest(OnixLocator locator) {
        onixAssert.checkCountOfElementByLocator(locator, 1);
    }
    @DataProvider
    public Object[] getMyGoalPageLocators() {
        return mergeArrays(
                MyGoal.Locator.values(),
                MyGoal.HomeHeaderLocator.values()
        );
    }
}
