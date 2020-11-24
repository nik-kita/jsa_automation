package test_package.automation;

import io.qameta.allure.Allure;
import junit.runner.BaseTestRunner;
import main_package.ui.data.User;
import main_package.ui.engine.FlyTester;
import main_package.ui.engine.OnixLocator;
import main_package.ui.engine.OnixWebElement;
import main_package.ui.guest_mode.page_objects.main.Main;
import main_package.ui.user_mode.page_objects.home_header.home.Home;
import main_package.ui.user_mode.page_objects.home_header.home.my_goal.MyGoal;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import test_package.test_engine.OnixTestRunner;

import java.time.format.DateTimeFormatter;
import java.util.Date;

public class WSHome extends OnixTestRunner {
    @Test
    public void myGoal() {
        Allure.link("Full test's info", "https://docs.google.com/spreadsheets/d/1gudjZ7fh4aUsozP7aPIovLnI4qGdbUFpIHJ6AbTlbC4/edit#gid=1648986495&range=C11:D11");
        log.info("1. Open https://www.jamessmithacademy.com/");
        Main main = openSite();
        for(OnixLocator l : Main.Locator.values()) {
            onixAssert.softCheckCountOfElementByLocator(l, 1);
        }
        log.debug("Check that 'Main' page is open.");
        log.info("2. Login to the site");
        Home home = main.goLoginPage().login(User.getValidUser());
        for(OnixLocator l : Home.Locator.values()) {
            onixAssert.softCheckCountOfElementByLocator(l, 1);
        }
        log.debug("Check that 'Home' page is open.");
        String firstGoalTitle = home.getCurrentGoalTitle();
        String firstGoalText = home.getCurrentGoalText();
        log.info("3. Click on 'My Goal'");
        MyGoal myGoal = home.clickMyGoalLink();
        for(OnixLocator l : MyGoal.Locator.values()) {
            onixAssert.softCheckCountOfElementByLocator(l, 1);
        }
        log.debug("Check that 'MyGoal' page is open.");
        String goalName = "Lose Fat";
        log.info("4. Select '{}' from 'Overall Goal'", goalName);
        myGoal = myGoal.selectGoalByString(goalName);
        Select select = new Select(driver.findElement(MyGoal.Locator.GOAL_SELECT).getSeleniumWebElement());
        String activeSelectOption = select.getFirstSelectedOption().getText();
        onixAssert.getSoftAssert().assertEquals(activeSelectOption, goalName);
        myGoal.fillMoreDetailTextarea("");
        log.info("Checking that selected option is displayed as active.");
        log.info("5. Click on 'Save' button with leaving empty 'in more details' textarea.");
        myGoal = myGoal.clickSaveButton();
        home = myGoal.clickHomeTab();
        onixAssert.getSoftAssert().assertEquals(firstGoalText, home.getCurrentGoalText());
        onixAssert.getSoftAssert().assertEquals(firstGoalTitle, home.getCurrentGoalTitle());
        log.info("Check that changes were not saved.");
        log.info("You should fill in the \"In more detail\" field");
        String text = "Blablabla";
        home = home.clickMyGoalLink().fillMoreDetailTextarea(text).selectGoalByString(goalName).clickSaveButton().clickHomeTab();
        onixAssert.getSoftAssert().assertEquals(goalName, home.getCurrentGoalTitle());
        onixAssert.getSoftAssert().assertEquals(text, home.getCurrentGoalText());
        log.info("Check that after filling textarea the goal was successfully saved.");
        log.debug("Return old values to these field for future retesting.");
        home.clickMyGoalLink()
                .selectGoalByString("Other")
                .fillMoreDetailTextarea("Test is successfully ended in " + new Date(System.currentTimeMillis()))
                .clickSaveButton()
                .openUserDropDown().logout().goMainPage();
        log.info("Logout");
        onixAssert.assertAll();
    }

    @Test
    public void weeklyGoal() {
        Allure.link("Full test's info", "https://docs.google.com/spreadsheets/d/1gudjZ7fh4aUsozP7aPIovLnI4qGdbUFpIHJ6AbTlbC4/edit#gid=1648986495&range=C24:D24");
        String testText = "Hello world! "  + new Date(System.currentTimeMillis()).toString();

        openSite(onixAssert)
                .goLoginPage(onixAssert)
                .login(User.getValidUser(), onixAssert)
                .clickMyGoalLink(onixAssert)
                .clickNewGoalButton(onixAssert)
                .save(testText, () -> {
                    boolean isSave = false;
                    for(OnixWebElement p : driver.findElements(MyGoal.Locators.WEEKLY_GOAL_LIST_ITEM_P)) {
                        if(p.text().equals(testText)) {
                            isSave = true;
                            break;
                        }
                    }
                    onixAssert.getSoftAssert().assertTrue(isSave);
                }).openUserDropDown().logout().goMainPage();

        onixAssert.assertAll();
    }

    @Test
    public void steps() {
        Allure.link("Full test's info", "https://docs.google.com/spreadsheets/d/1gudjZ7fh4aUsozP7aPIovLnI4qGdbUFpIHJ6AbTlbC4/edit?ts=5f7593b0#gid=1648986495&range=C34:D34");
        int stepsForTest = (int)(Math.random() * 10);
        openSite(onixAssert)
                .goLoginPage(onixAssert)
                .login(User.getValidUser(), onixAssert)
                .clickStepsLink(onixAssert)
                .clickEditTodayStepsIconButton(onixAssert)
                .update(stepsForTest, () -> {

                });
    }

}
