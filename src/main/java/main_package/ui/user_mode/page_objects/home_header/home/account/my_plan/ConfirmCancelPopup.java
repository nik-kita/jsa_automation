package main_package.ui.user_mode.page_objects.home_header.home.account.my_plan;

import main_package.ui.BasePageObject;
import main_package.ui.engine.FlyTester;
import main_package.ui.engine.OnixLocator;
import main_package.ui.engine.OnixWebDriver;
import org.openqa.selenium.By;

public class ConfirmCancelPopup extends BasePageObject {
    public ConfirmCancelPopup(OnixWebDriver driver) {
        super(driver);
    }

    public MyPlan close() {
        driver.waitToClick(Locator.CLOSE_BUTTON).click();
        logger.warn("click!");
        return new MyPlan(driver);
    }
    @Override
    public ConfirmCancelPopup test(FlyTester flyTester) {
        flyTester.test();
        return this;
    }

    public enum Locator implements OnixLocator {
        MAIN_REASON_SELECT(By.cssSelector("select#main_reason")),
        LET_US_KNOW_TEXTAREA(By.cssSelector("textarea#explanation")),
        SUBMIT_FEEDBACK_BUTTON(By.cssSelector("button[onclick='_postFeedback()']")),
        CANCEL_SUBSCRIPTION_BUTTON(By.cssSelector("button[name='submitButton']")),
        CLOSE_BUTTON(By.cssSelector("#cancelModal button.close span")),

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
