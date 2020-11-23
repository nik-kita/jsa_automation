package test_package.automation;

import io.qameta.allure.Allure;
import junit.runner.BaseTestRunner;
import main_package.ui.data.User;
import main_package.ui.engine.OnixLocator;
import main_package.ui.guest_mode.page_objects.main.Main;
import main_package.ui.user_mode.page_objects.home_header.home.Home;
import main_package.ui.user_mode.page_objects.home_header.home.my_goal.MyGoal;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import test_package.test_engine.OnixTestRunner;

public class WSHome extends OnixTestRunner {
    @Test
    public void myGoal() {
        Allure.link("Full test's info", "https://docs.google.com/spreadsheets/d/1gudjZ7fh4aUsozP7aPIovLnI4qGdbUFpIHJ6AbTlbC4/edit#gid=1648986495&range=C11:D11");
        log.debug("1. Open https://www.jamessmithacademy.com/");
        Main main = openSite(onixAssert.getSoftAssert());
        log.debug("2. Log in to the site");
        Home home = main.goLoginPage().login(User.getValidUser(), onixAssert.getSoftAssert());
        String firstGoalTitle = home.getCurrentGoalTitle();
        String firstGoalText = home.getCurrentGoalText();
        log.debug("3. Click on 'My Goal'");
        MyGoal myGoal = home.clickMyGoalLink(onixAssert.getSoftAssert());
        log.debug("4. Select any of 'Overall Goal'");
        String goalName = "Improve CV";
        myGoal = myGoal.selectGoalByString(goalName);
        String text = driver.findElement(MyGoal.Locator.GOAL_SELECT).text();
        onixAssert.getSoftAssert().assertEquals(text, goalName);
        log.info("Selected overall goal is shown");
        log.debug("5. Click on 'Save' button");
        myGoal = myGoal.clickSaveButton();
        home = myGoal.clickHomeTab();
        onixAssert.getSoftAssert().assertEquals(firstGoalText, home.getCurrentGoalText());
        onixAssert.getSoftAssert().assertEquals(firstGoalTitle, home.getCurrentGoalTitle());
        log.info("You should fill in the \"In more detail\" field");
        home = home.clickMyGoalLink().fillMoreDetailTextarea("Blablabla").clickSaveButton().clickHomeTab();
        onixAssert.assertAll();


    }
}
