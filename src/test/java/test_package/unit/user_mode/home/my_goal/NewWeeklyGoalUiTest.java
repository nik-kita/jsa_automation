package test_package.unit.user_mode.home.my_goal;

import main_package.ui.user_mode.JsaLoginBaseUiTestRunner;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.engine.OnixLocator;
import main_package.ui.user_mode.page_objects.home_header.home.my_goal.NewWeeklyGoal;

public class NewWeeklyGoalUiTest extends JsaLoginBaseUiTestRunner {
    @BeforeClass
    public void openNewWeeklyGoalPopup() {
        homeLoginModePO.clickMyGoalLink().clickNewGoalButton();
    }
    @Test(dataProvider = "newWeeklyGoalLocators")
    public void newWeeklyGoalTest(OnixLocator locator) {
        onixUiAssert.checkCountOfElementByLocator(locator, 1);
    }
    @DataProvider
    public Object[] newWeeklyGoalLocators() {
        return NewWeeklyGoal.Locator.values();
    }
}
