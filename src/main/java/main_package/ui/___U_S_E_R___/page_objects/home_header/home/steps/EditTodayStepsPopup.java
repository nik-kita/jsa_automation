package main_package.ui.___U_S_E_R___.page_objects.home_header.home.steps;


import main_package.ui.BasePageObject;
import main_package.engine.test_engine.FlyTester;
import main_package.engine.test_engine.OnixUiAssert;
import main_package.engine.OnixLocator;
import main_package.engine.OnixWebDriver;
import org.openqa.selenium.By;

public class EditTodayStepsPopup extends BasePageObject {
    public EditTodayStepsPopup(OnixWebDriver driver) {
        super(driver);
    }
    @Override
    public EditTodayStepsPopup test(FlyTester flyTester) {
        flyTester.test();
        return this;
    }

    public Steps close() {
        driver.findElement(Locator.CLOSE_BUTTON).click();
        logger.info("Close 'Add Today's Steps' popup");
        if(driver.isElementPresent(Locator.CLOSE_BUTTON)) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                logger.warn("Waiting for invisibility of modal window (popup).");
            }
        }
        return new Steps(driver);
    }
    public Steps close(OnixUiAssert onixUiAssert) {
        close();
        for(OnixLocator l : Steps.Locator.values()) {
            onixUiAssert.softCheckCountOfElementByLocator(l, 1);
        }
        return new Steps(driver);
    }
    public Steps update(int steps) {
        driver.findElement(Locator.TODAY_STEPS_INPUT).getSeleniumWebElement().clear();
        driver.findElement(Locator.TODAY_STEPS_INPUT).sendKeys(String.valueOf(steps));
        logger.info("Write '{}' into today step's input.", steps);
        driver.findElement(Locator.UPDATE_BUTTON).click();
        if(driver.isElementPresent(Locator.UPDATE_BUTTON)) {
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
        TODAY_STEPS_INPUT(By.cssSelector("input[name='steps']")),
        UPDATE_BUTTON(By.cssSelector(".todays_step_form .btn-primary"))
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

    public enum Locators implements OnixLocator {
        ;
        private By path;

        Locators(By path) {
            this.path = path;
        }

        @Override
        public By getPath() {
            return path;
        }
    }
}

