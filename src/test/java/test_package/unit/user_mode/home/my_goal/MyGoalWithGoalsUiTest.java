package main_package.ui.user_mode.home.my_goal;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.engine.OnixLocator;
import main_package.ui.user_mode.JsaLoginBaseUiTestRunner;
import main_package.ui.user_mode.page_objects.home_header.home.my_goal.MyGoal;

public class MyGoalWithGoalsUiTest extends JsaLoginBaseUiTestRunner {
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
        onixUiAssert.checkMinimumOfElementsByLocator(locator, 0);
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
