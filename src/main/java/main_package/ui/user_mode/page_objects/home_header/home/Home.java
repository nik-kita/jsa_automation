package main_package.ui.user_mode.page_objects.home_header.home;

import main_package.engine.test_engine.FlyTester;
import main_package.engine.test_engine.OnixUiAssert;
import main_package.ui.related_sites.FacebookGroupPage;
import main_package.ui.user_mode.page_objects.home_header.home.account.my_plan.MyPlan;
import main_package.ui.user_mode.page_objects.home_header.home.steps.Steps;
import org.openqa.selenium.By;
import main_package.ui.BasePageObject;
import main_package.engine.OnixLocator;
import main_package.engine.OnixWebDriver;
import main_package.ui.user_mode.general_parts.home.HomePart;
import main_package.ui.user_mode.page_objects.home_header.home.my_goal.MyGoal;
import main_package.ui.user_mode.page_objects.home_header.home.my_progress.MyProgress;

public class Home extends BasePageObject implements HomePart {
    public Home(OnixWebDriver driver) {
        super(driver);
        logger.debug("'Home' page is open.");
    }
    @Override
    public Home test(FlyTester flyTester) {
        flyTester.test();
        return this;
    }

    public String getCurrentGoalTitle() {
        String result = driver.findElement(By.cssSelector(".my_goal_overview_body_heading")).text();
        logger.info("The current goal title is: '{}'", result);
        return result;
    }
    public String getCurrentGoalText() {
        String result = driver.findElement(By.cssSelector(".my_goal_overview_body_goal")).text();
        logger.info("The current goal text is: '{}'", result);
        return result;
    }

    public MyPlan clickAccountIcon() {
        driver.findElement(Locator.MY_PLAN_ACCOUNT_ICON_LINK).click();
        logger.debug("'Account' from 'Home'");
        return new MyPlan(driver);
    }
    public MyGoal clickMyGoalLink() {
        driver.findElement(Locator.MY_GOAL_DIV_LINK).click();
        logger.debug("'MyGoal' from 'Home'");
        return new MyGoal(driver);
    }
    public MyGoal clickMyGoalLink(OnixUiAssert onixUiAssert) {
        driver.findElement(Locator.MY_GOAL_DIV_LINK).click();
        logger.info("Click on 'My Goal' link.");
        for(OnixLocator l : MyGoal.Locator.values()) {
            onixUiAssert.softCheckCountOfElementByLocator(l, 1);
        }
        return new MyGoal(driver);
    }

    public Steps clickStepsLink() {
        driver.findElement(Locator.STEPS_DIV_LINK).click();
        logger.info("Click on 'Steps' link.");
        return new Steps(driver);
    }
    public Steps clickStepsLink(OnixUiAssert onixUiAssert) {
        driver.findElement(Locator.STEPS_DIV_LINK).click();
        for(OnixLocator l : Steps.Locator.values()) {
            onixUiAssert.softCheckCountOfElementByLocator(l, 1);
        }
        logger.info("Click on 'Steps' link.");
        return new Steps(driver);
    }

    public MyProgress clickMyProgressLink() {
        driver.findElement(Locator.MY_PROGRESS_DIV_LINK).click();
        return new MyProgress(driver);
    }

    public Challenges clickChallenges() {
        driver.findElement(Locator.CHALLENGE_DIV_LINK).click();
        return new Challenges(driver);
    }
//TODO for SimpleUser mode
//    public PricingPlans clickUpgradeToAccess() {
//        driver.findElement(Locator.UPGRADE_TO_ACCESS_BTN).click();
//        return new PricingPlans(driver);
//    }


    public FacebookGroupPage clickJoinNow() {
        driver.findElement(Locator.JOIN_NOW_BUTTON_LINK).click();
        driver.switchAnotherTab("jsa");
        logger.debug("'FacebookGroup' from 'Home'");
        return new FacebookGroupPage(driver);
    }

    public enum Locator implements OnixLocator {
        MY_PLAN_ACCOUNT_ICON_LINK(By.cssSelector("[href='/users/account/my-plan']")),
        GET_STARTED_6_STEPS_DIV_LINK(By.cssSelector("[href='#/home/step-two']")),
        MY_GOAL_DIV_LINK(By.cssSelector("[href='#/home/my-goal']")),
        STEPS_DIV_LINK(By.cssSelector("[href='#/home/steps']")),
        EDIT_IMG_BTM_IN_STEPS_DIV(By.cssSelector(".todays_steps img")),
        MY_PROGRESS_DIV_LINK(By.cssSelector("[href='#/home/my-progress']")),
        CHALLENGE_DIV_LINK(By.cssSelector("[href='#/home/challenges']")),
        JOIN_NOW_BUTTON_LINK(By.cssSelector("[href=\"https://www.facebook.com/groups/193449874723532/\"]")),
//        UPGRADE_TO_ACCESS_BTN(By.cssSelector(".facebook_group [href='/users/pricing/']")),

        ;

        private By path;

        Locator(By path) {
            this.path = path;
        }
        @Override
        public By getPath() {
            return path;
        }
    }


}
