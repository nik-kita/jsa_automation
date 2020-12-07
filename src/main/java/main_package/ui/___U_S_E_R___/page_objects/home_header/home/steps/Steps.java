package main_package.ui.___U_S_E_R___.page_objects.home_header.home.steps;

import main_package.engine.test_engine.FlyTester;
import main_package.engine.test_engine.OnixUiAssert;
import org.openqa.selenium.By;
import main_package.ui.BasePageObject;
import main_package.engine.OnixLocator;
import main_package.engine.OnixWebDriver;
import main_package.ui.___U_S_E_R___.general_parts.home.HomeHeaderPart;

public class Steps extends BasePageObject implements HomeHeaderPart {
    public Steps(OnixWebDriver driver) {
        super(driver);
        logger.debug("'Steps' page is open.");
    }
    @Override
    public Steps test(FlyTester flyTester) {
        flyTester.test();
        return this;
    }

    public EditYourGoalStepsPopup clickEditYourStepsGoalIconPenButton() {
        driver.findElement(Locator.EDIT_YOUR_GOAL_BUTTON).click();
        logger.info("Click on 'Edit Your Goal' icon pen-button.");
        return new EditYourGoalStepsPopup(driver);
    }
    public EditYourGoalStepsPopup clickEditYourStepsGoalIconPenButton(OnixUiAssert onixUiAssert) {
        EditYourGoalStepsPopup editYourGoalStepsPopup = clickEditYourStepsGoalIconPenButton();
        for(OnixLocator l : EditYourGoalStepsPopup.Locator.values()) {
            onixUiAssert.softCheckCountOfElementByLocator(l, 1);
        }
        return editYourGoalStepsPopup;
    }

    public EditTodayStepsPopup clickEditTodayStepsIconButton() {
        driver.findElement(Locator.EDIT_TODAY_STEPS_BUTTON).click();
        logger.info("Click on 'Edit Today Steps' icon pen-button.");
        return new EditTodayStepsPopup(driver);
    }
    public EditTodayStepsPopup clickEditTodayStepsIconButton(OnixUiAssert onixUiAssert) {
        driver.findElement(Locator.EDIT_TODAY_STEPS_BUTTON).click();
        logger.info("Click on 'Edit Today Steps' icon pen-button.");
        for(OnixLocator l : EditTodayStepsPopup.Locator.values()) {
            onixUiAssert.softCheckCountOfElementByLocator(l, 1);
        }
        return new EditTodayStepsPopup(driver);
    }
    public int getTodaySteps() {
        logger.debug("Get current today step's value.");
        return Integer.parseInt(driver.findElement(Locator.TODAY_STEPS_VALUE).text());
    }

    public int getGoalSteps() {
        logger.debug("Get current goal for steps.");
        return Integer.parseInt(driver.findElement(Locator.STEPS_GOAL_VALUE).text());
    }

    public int getDailyAverageValue() {
        logger.debug("Get daily average of steps.");
        if(driver.findElement(Locator.DAILY_AVERAGE_STEPS_VALUE).text().length() == 0) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                logger.warn("Waiting while daily average number is displaying.");
            }
        }
        return Integer.parseInt(driver.findElement(Locator.DAILY_AVERAGE_STEPS_VALUE).text());
    }

    public Steps clickOneWeekButton() {
        logger.debug("Click to '1 W' button.");
        driver.findElement(Locator.ONE_WEEK_BUTTON).click();
        return this;
    }
    public Steps clickOneMonthButton() {
        logger.debug("Click to '1 M' button.");
        driver.findElement(Locator.ONE_MONTH_BUTTON).click();
        return this;
    }
    public Steps clickThreeMonthsButton() {
        logger.debug("Click to '3 M' button.");
        driver.findElement(Locator.THREE_MONTH_BUTTON).click();
        return this;
    }



    public enum Locator implements OnixLocator {
        BACK_HOME_ARROW(By.xpath("//a[@href='#/home']/img")),
        EDIT_YOUR_GOAL_BUTTON(By.cssSelector(".steps_goal img")),
        EDIT_TODAY_STEPS_BUTTON(By.cssSelector(".todays_steps img")),
        ONE_WEEK_BUTTON(By.xpath("//div[text() = '1 W']")),
        ONE_MONTH_BUTTON(By.xpath("//div[text() = '1 M']")),
        THREE_MONTH_BUTTON(By.xpath("//div[text()= '3 M']")),
        TODAY_STEPS_VALUE(By.cssSelector(".todays_steps_value")),
        STEPS_GOAL_VALUE(By.cssSelector(".steps_goal_value")),
        DAILY_AVERAGE_STEPS_VALUE(By.cssSelector(".average_steps_value")),

        ;
        Locator(By path) {
            this.path = path;
        }

        private By path;

        @Override
        public By getPath() {
            return path;
        }
    }
}
