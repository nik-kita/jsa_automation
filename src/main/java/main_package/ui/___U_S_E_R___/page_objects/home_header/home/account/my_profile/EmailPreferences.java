package main_package.ui.___U_S_E_R___.page_objects.home_header.home.account.my_profile;

import main_package.ui.BasePageObject;
import main_package.engine.test_engine.FlyTester;
import main_package.engine.OnixLocator;
import main_package.engine.OnixWebDriver;
import main_package.ui.___U_S_E_R___.general_parts.home.account.AccountHeader;
import org.openqa.selenium.By;

public class EmailPreferences extends BasePageObject implements AccountHeader {
    public EmailPreferences(OnixWebDriver driver) {
        super(driver);
    }
    @Override
    public EmailPreferences test(FlyTester flyTester) {
        flyTester.test();
        return this;
    }
    public enum Locator implements OnixLocator {
        OPT_OUT_OF_ALL_EMAILS_SELECT(By.cssSelector("[name=\"globalUnsubscribe\"]")),
        //TODO may be these locator true only for specific user
        DAILY_EMAILS_SELECT(By.cssSelector("[name=\"list-14588\"]")),
        CHALLENGE_WAITING_LIST_SELECT(By.cssSelector("[name=\"list-14589\"]")),
        WELCOME_EMAILS_SELECT(By.cssSelector("[name=\"list-14590\"]")),
        UPDATE_PREFERENCES_BUTTON(By.cssSelector("[name='submitButton']")),




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
