package ui.user_mode.home.my_goal;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ui.BasePageObject;
import ui.engine.OnixLocator;
import ui.user_mode.JsaLoginBaseTestRunner;
import ui.user_mode.page_objects.home_header.home.my_goal.NewWeeklyGoal;

public class NewWeeklyGoalTest extends JsaLoginBaseTestRunner {
    @BeforeClass
    public void openNewWeeklyGoalPopup() {
        homeLoginModePO.clickMyGoalLink().clickNewGoalButton();
    }
    @Test(dataProvider = "newWeeklyGoalLocators")
    public void newWeeklyGoalTest(OnixLocator locator) {
        onixAssert.checkCountOfElementByLocator(locator, 1);
    }
    @DataProvider
    public Object[] newWeeklyGoalLocators() {
        return NewWeeklyGoal.Locator.values();
    }
}
