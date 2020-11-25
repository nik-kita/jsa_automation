package main_package.ui.user_mode.page_objects.home_header.home.steps;


import main_package.ui.BasePageObject;
import main_package.ui.engine.FlyTester;
import main_package.ui.engine.OnixAssert;
import main_package.ui.engine.OnixLocator;
import main_package.ui.engine.OnixWebDriver;
import main_package.ui.user_mode.general_parts.home.HomePart;
import org.openqa.selenium.By;

public class EditYourGoalStepsPopup extends BasePageObject {

    public EditYourGoalStepsPopup(OnixWebDriver driver) {
        super(driver);
    }

    @Override
    public EditYourGoalStepsPopup test(FlyTester flyTester) {
        flyTester.test();
        return this;
    }

    public Steps close() {
        driver.findElement(EditTodayStepsPopup.Locator.CLOSE_BUTTON).click();
        logger.info("Close 'Daily Step Goal' popup");
        if(driver.isElementPresent(EditTodayStepsPopup.Locator.CLOSE_BUTTON)) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                logger.warn("Waiting for invisibility of modal window (popup).");
            }
        }
        return new Steps(driver);
    }
    public Steps close(OnixAssert onixAssert) {
        close();
        for(OnixLocator l : Steps.Locator.values()) {
            onixAssert.softCheckCountOfElementByLocator(l, 1);
        }
        return new Steps(driver);
    }
    public Steps update(int steps) {
        driver.findElement(EditYourGoalStepsPopup.Locator.DAILY_STEP_GOAL_INPUT).getSeleniumWebElement().clear();
        driver.findElement(EditYourGoalStepsPopup.Locator.DAILY_STEP_GOAL_INPUT).sendKeys(String.valueOf(steps));
        logger.info("Write '{}' into today step's input.", steps);
        driver.findElement(Locator.SAVE_BUTTON).click();
        if(driver.isElementPresent(Locator.SAVE_BUTTON)) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                logger.warn("Waiting for invisibility of modal window (popup).");
            }
        }
        return new Steps(driver);
    }

    public enum Locator implements OnixLocator {
        CLOSE_BUTTON(By.cssSelector(".modal-window .btn img")),
        DAILY_STEPS_GOAL_INPUT(By.cssSelector("input[name='steps']")),
        DAILY_STEP_GOAL_INPUT(By.cssSelector("input[name='steps']")),
        SAVE_BUTTON(By.cssSelector(".steps_goal_form .btn-primary"))

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

//    public enum Locators implements OnixLocator {
//        ;
//        private By path;
//
//        Locators(By path) {
//            this.path = path;
//        }
//
//        @Override
//        public By getPath() {
//            return path;
//        }
//    }
}
