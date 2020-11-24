package main_package.ui.user_mode.page_objects.home_header.home.steps;

import main_package.ui.engine.FlyTester;
import main_package.ui.engine.OnixAssert;
import org.openqa.selenium.By;
import main_package.ui.BasePageObject;
import main_package.ui.engine.OnixLocator;
import main_package.ui.engine.OnixWebDriver;
import main_package.ui.user_mode.general_parts.home.HomeHeaderPart;

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
    public EditYourGoalStepsPopup clickEditYourStepsGoalIconPenButton(OnixAssert onixAssert) {
        EditYourGoalStepsPopup editYourGoalStepsPopup = clickEditYourStepsGoalIconPenButton();
        for(OnixLocator l : EditYourGoalStepsPopup.Locator.values()) {
            onixAssert.softCheckCountOfElementByLocator(l, 1);
        }
        return editYourGoalStepsPopup;
    }

    public EditTodayStepsPopup clickEditTodayStepsIconButton() {
        driver.findElement(Locator.EDIT_TODAY_STEPS_BUTTON).click();
        logger.info("Click on 'Edit Today Steps' icon pen-button.");
        return new EditTodayStepsPopup(driver);
    }
    public EditTodayStepsPopup clickEditTodayStepsIconButton(OnixAssert onixAssert) {
        driver.findElement(Locator.EDIT_TODAY_STEPS_BUTTON).click();
        logger.info("Click on 'Edit Today Steps' icon pen-button.");
        for(OnixLocator l : EditTodayStepsPopup.Locator.values()) {
            onixAssert.softCheckCountOfElementByLocator(l, 1);
        }
        return new EditTodayStepsPopup(driver);
    }
    public int getTodaySteps() {
        logger.debug("Get current today step's value.");
        return Integer.parseInt(driver.findElement(Locator.TODAY_STEPS_VALUE).text());
    }




    public enum Locator implements OnixLocator {
        BACK_HOME_ARROW(By.xpath("//a[@href='#/home']/img")),
        EDIT_YOUR_GOAL_BUTTON(By.cssSelector(".steps_goal img")),
        EDIT_TODAY_STEPS_BUTTON(By.cssSelector(".todays_steps img")),
        ONE_WEEK_BUTTON(By.xpath("//div[text() = '1 W']")),
        ONE_MONTH_BUTTON(By.xpath("//div[text() = '1 M']")),
        THREE_MONTH_BUTTON(By.xpath("//div[text()= '3 M']")),
        TODAY_STEPS_VALUE(By.cssSelector(".todays_steps_value")),

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
