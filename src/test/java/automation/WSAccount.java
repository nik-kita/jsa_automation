package automation;

import io.qameta.allure.Allure;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test_engine.OnixTestRunner;
import ui.data.User;
import ui.engine.OnixLocator;
import ui.guest_mode.page_objects.main.Main;
import ui.guest_mode.page_objects.main.login.Login;
import ui.user_mode.page_objects.home_header.home.Home;
import ui.user_mode.page_objects.home_header.home.Steps;
import ui.user_mode.page_objects.home_header.home.my_goal.MyGoal;

public class WSAccount extends OnixTestRunner {
    Main main;

    @BeforeClass
    public void startFromMainPage() {
        main = openSite();
        log.info("open site");
    }

    @Test(testName = "Check base functionality of Home and relative pages")
    public void home() {
        Allure.link("Full test case information" , "https://docs.google.com/spreadsheets/d/1gudjZ7fh4aUsozP7aPIovLnI4qGdbUFpIHJ6AbTlbC4/edit?ts=5f7593b0#gid=1204697450&range=B2");
        Allure.step("Main page");
        for(OnixLocator l : Main.Locator.values()) {
            onixAssert.softCheckCountOfElementByLocator(l, 1);
        }
        Login login = main.goLoginPage();
        Allure.step("Login page");
        for(OnixLocator l : Login.Locator.values()) {
            onixAssert.softCheckCountOfElementByLocator(l, 1);
        }
        Home home = login.login(User.getValidUser());
        Allure.step("Home page");
        MyGoal myGoal = home.clickMyGoalLink();
        for(OnixLocator l : Home.Locator.values()) {
            onixAssert.softCheckCountOfElementByLocator(l, 1);
        }
        String goal_1 = "Make this world little better by automation all tests in the world!";
        String goal_2 = "If not in all world so on this site...";
        Allure.step("Create two new weekly goals");
        myGoal = myGoal
                .clickNewGoalButton()
                .save(goal_1)
                .clickNewGoalButton()
                .save(goal_2);
        onixAssert.softCheckCountOfElementByLocator(myGoal.weeklyGoal, 2);
        myGoal.clickDeleteWeeklyGoal(goal_1);
        onixAssert.softCheckCountOfElementByLocator(myGoal.weeklyGoal,1 );
        Allure.step("Remove one goal, check alert presence");
        onixAssert.softCheckCountOfElementByLocator(myGoal.doneGray, 1);
        myGoal.clickAcceptWeeklyGoal(goal_2);
        onixAssert.softCheckCountOfElementByLocator(myGoal.doneActive, 1);
        Allure.step("Check activation checklist item");
        Steps steps = myGoal.clickBackArrow().clickStepsLink();
        Allure.step("Steps page open");
        for(OnixLocator l : Steps.Locator.values()) {
            onixAssert.softCheckCountOfElementByLocator(l, 1);
        }






    }
}
