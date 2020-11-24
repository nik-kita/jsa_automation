package main_package.ui.user_mode.page_objects.home_header.home.my_goal;

import main_package.ui.engine.FlyTester;
import main_package.ui.engine.OnixAssert;
import org.openqa.selenium.By;
import main_package.ui.BasePageObject;
import main_package.ui.engine.OnixLocator;
import main_package.ui.engine.OnixWebDriver;

public class NewWeeklyGoal extends BasePageObject {

    public NewWeeklyGoal(OnixWebDriver driver) {
        super(driver);
        logger.debug("'NewWeeklyGoal' modal window is open.");
    }
    @Override
    public NewWeeklyGoal test(FlyTester flyTester) {
        flyTester.test();
        return this;
    }

    public MyGoal clickCloseButton() {
        driver.findElement(Locator.CLOSE_X_BUTTON).click();
        logger.debug("'MyGoal' from 'NewWeeklyGoal'");
        return new MyGoal(driver);
    }
    public MyGoal save(String text) {
        driver.findElement(Locator.GAOL_TEXTAREA).sendKeys(text);
        driver.findElement(Locator.SAVE_BUTTON).click();
        if(driver.isElementPresent(Locator.SAVE_BUTTON)) {
            try {
                Thread.sleep(500);
            } catch(InterruptedException e) {
                logger.error(e.getMessage());
            }
            logger.warn("Waiting for invisibility of 'Save Button'");
        }
        logger.debug("Click 'Save' button after adding some text('{}')", text);
        return new MyGoal(driver);
    }
    public MyGoal save(String text, OnixAssert onixAssert) {
        driver.findElement(Locator.GAOL_TEXTAREA).sendKeys(text);
        driver.findElement(Locator.SAVE_BUTTON).click();
        if(driver.isElementPresent(Locator.SAVE_BUTTON)) {
            try {
                Thread.sleep(500);
            } catch(InterruptedException e) {
                logger.error(e.getMessage());
            }
            logger.warn("Waiting for invisibility of 'Save Button'");
        }
        logger.debug("Click 'Save' button after adding some text('{}')", text);
        for(OnixLocator l : MyGoal.Locator.values()) {
            onixAssert.softCheckCountOfElementByLocator(l, 1);
        }
        return new MyGoal(driver);
    }
    public MyGoal save(String text, FlyTester flyTester) {
        driver.findElement(Locator.GAOL_TEXTAREA).sendKeys(text);
        driver.findElement(Locator.SAVE_BUTTON).click();
        if(driver.isElementPresent(Locator.SAVE_BUTTON)) {
            try {
                Thread.sleep(500);
            } catch(InterruptedException e) {
                logger.error(e.getMessage());
            }
            logger.warn("Waiting for invisibility of 'Save Button'");
        }
        logger.debug("Click 'Save' button after adding some text('{}')", text);
        flyTester.test();
        return new MyGoal(driver);
    }



    public enum Locator implements OnixLocator {
        CLOSE_X_BUTTON(By.xpath("//button//img[contains(@src, 'close')]")),
        GAOL_TEXTAREA(By.cssSelector(".new_weekly_goal_form textarea[name='goal']")),
        SAVE_BUTTON(By.xpath("//div[@class='modal-window']//button[text()='Save']")),

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
