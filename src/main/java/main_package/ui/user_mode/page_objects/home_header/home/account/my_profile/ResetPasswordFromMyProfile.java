package main_package.ui.user_mode.page_objects.home_header.home.account.my_profile;

import main_package.ui.BasePageObject;
import main_package.engine.test_engine.FlyTester;
import main_package.engine.OnixLocator;
import main_package.engine.OnixWebDriver;
import main_package.ui.user_mode.general_parts.Footer;
import main_package.ui.user_mode.general_parts.home.account.AccountHeader;
import org.openqa.selenium.By;

public class ResetPasswordFromMyProfile extends BasePageObject implements Footer, AccountHeader {

    public ResetPasswordFromMyProfile(OnixWebDriver driver) {
        super(driver);
    }
    @Override
    public ResetPasswordFromMyProfile test(FlyTester flyTester) {
        flyTester.test();
        return this;
    }
    public enum Locator implements OnixLocator {
        OLD_PASSWORD_INPUT(By.cssSelector("[name='old_password']")),
        NEW_PASSWORD_INPUT(By.cssSelector("[name='new_password1']")),
        NEW_PASSWORD_CONFIRM(By.cssSelector("[name='new_password2']")),
        ENTER_BUTTON(By.cssSelector("form button")),
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
