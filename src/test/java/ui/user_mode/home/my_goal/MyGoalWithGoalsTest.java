package ui.user_mode.home.my_goal;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ui.engine.OnixLocator;
import ui.user_mode.JsaLoginBaseTestRunner;
import ui.user_mode.page_objects.home_header.home.my_goal.MyGoal;

public class MyGoalWithGoalsTest extends JsaLoginBaseTestRunner {
    MyGoal myGoal;
    @BeforeClass
    public void goMyGoalAndCreateWeeklyGoals() {
        String[] goals = new String[]{
                "Hello world!",
                "JSA",
                "Ok Google!",
                "Linux better than Windows"
        };
        myGoal = homeLoginModePO.clickMyGoalLink();
        for (String g : goals) {
            myGoal = myGoal.clickNewGoalButton().save(g);
        }
        myGoal = myGoal.clickAcceptWeeklyGoal(0);
    }

    @Test(dataProvider = "multiLocators")
    public void myGoalTestMultiLocators(OnixLocator locator) {
        onixAssert.checkMinimumOfElementsByLocator(locator, 0);
    }
    @DataProvider
    public Object[] multiLocators() {
        return new Object[]{
                myGoal.doneActive,
                myGoal.weeklyGoal,
                myGoal.optionInGoalSelect,
                myGoal.doneGray
        };
    }
}
