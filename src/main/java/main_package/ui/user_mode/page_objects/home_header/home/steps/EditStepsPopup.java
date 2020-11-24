package main_package.ui.user_mode.page_objects.home_header.home.steps;


import main_package.ui.BasePageObject;
import main_package.ui.engine.FlyTester;
import main_package.ui.engine.OnixAssert;
import main_package.ui.engine.OnixLocator;
import main_package.ui.engine.OnixWebDriver;
import main_package.ui.user_mode.general_parts.home.HomePart;
import main_package.ui.user_mode.page_objects.home_header.home.account.my_profile.upload_image.LocalFiles;
import org.openqa.selenium.By;

public class EditStepsPopup extends BasePageObject implements HomePart {
    public EditStepsPopup(OnixWebDriver driver) {
        super(driver);
    }
    @Override
    public EditStepsPopup test(FlyTester flyTester) {
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
    public Steps close(OnixAssert onixAssert) {
        close();
        for(OnixLocator l : Steps.Locator.values()) {
            onixAssert.softCheckCountOfElementByLocator(l, 1);
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

