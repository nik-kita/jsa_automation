package ui.user_mode.page_objects.home_header.home;

import org.openqa.selenium.By;
import ui.BasePageObject;
import ui.engine.OnixLocator;
import ui.engine.OnixWebDriver;
import ui.user_mode.general_parts.home.HomePart;
import ui.user_mode.page_objects.home_header.home.my_goal.MyGoal;
import ui.user_mode.page_objects.home_header.home.my_progress.ImagesTab;
import ui.user_mode.page_objects.home_header.home.my_progress.MyProgress;

public class Home extends BasePageObject implements HomePart {
    public Home(OnixWebDriver driver) {
        super(driver);
    }

    public Account clickAccountIcon() {
        driver.findElement(Locator.MY_PLAN_ACCOUNT_ICON_LINK).click();
        logger.debug("'Account' from 'Home'");
        return new Account(driver);
    }
    public MyGoal clickMyGoalLink() {
        driver.findElement(Locator.MY_GOAL_DIV_LINK).click();
        logger.debug("'MyGoal' from 'Home'");
        return new MyGoal(driver);
    }

    public Steps clickStepsLink() {
        driver.findElement(Locator.STEPS_DIV_LINK).click();
        return new Steps(driver);
    }

    public MyProgress clickMyProgressLink() {
        driver.findElement(Locator.MY_PROGRESS_DIV_LINK).click();
        return new MyProgress(driver);
    }

    public enum Locator implements OnixLocator {
        MY_PLAN_ACCOUNT_ICON_LINK(By.cssSelector("[href='/users/account/my-plan")),
        GET_STARTED_6_STEPS_DIV_LINK(By.cssSelector("[href='#/home/step-two']")),
        MY_GOAL_DIV_LINK(By.cssSelector("[href='#/home/my-goal']")),
        STEPS_DIV_LINK(By.cssSelector("[href='#/home/steps']")),
        EDIT_IMG_BTM_IN_STEPS_DIV(By.cssSelector(".todays_steps img")),
        MY_PROGRESS_DIV_LINK(By.cssSelector("[href='#/home/my-progress']")),
        CHALLENGE_DIV_LINK(By.cssSelector("[href='#/home/challenges']")),
        UPGRADE_TO_ACCESS_BTN(By.cssSelector(".facebook_group [href='/users/pricing/']")),

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
