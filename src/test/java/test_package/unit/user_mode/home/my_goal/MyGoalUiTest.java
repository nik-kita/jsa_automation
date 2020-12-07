package test_package.unit.user_mode.home.my_goal;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.engine.OnixLocator;
import main_package.ui.___U_S_E_R___.page_objects.home_header.home.my_goal.MyGoal;
import main_package.engine.test_engine.JsaLoginBaseUiTestRunner;

public class MyGoalUiTest extends JsaLoginBaseUiTestRunner {
    @BeforeClass
    public void goMyGoalPage() {
        homeLoginModePO.clickMyGoalLink();
    }
    @Test(dataProvider = "getMyGoalPageLocators")
    public void myGoalTest(OnixLocator locator) {
        onixUiAssert.checkCountOfElementByLocator(locator, 1);
    }
    @DataProvider
    public Object[] getMyGoalPageLocators() {
        return mergeArrays(
                MyGoal.Locator.values(),
                MyGoal.HomeHeaderLocator.values()
        );
    }
}
