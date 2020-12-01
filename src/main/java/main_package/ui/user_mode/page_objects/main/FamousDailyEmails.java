package main_package.ui.user_mode.page_objects.main;

import main_package.engine.test_engine.FlyTester;
import org.openqa.selenium.By;
import main_package.ui.BasePageObject;
import main_package.engine.OnixLocator;
import main_package.engine.OnixWebDriver;
import main_package.ui.user_mode.general_parts.Footer;
import main_package.ui.user_mode.general_parts.MainHeader;

public class FamousDailyEmails extends BasePageObject implements MainHeader, Footer {
    public FamousDailyEmails(OnixWebDriver driver) {
        super(driver);
    }
    @Override
    public FamousDailyEmails test(FlyTester flyTester) {
        flyTester.test();
        return this;
    }
    public enum Locator implements OnixLocator {
        EMAIL_INPUT(By.cssSelector("form input[name='email']")),
        SIGN_UP_BUTTON(By.cssSelector("form button#submit")),
        SUBSCRIBE_BUTTON(By.xpath("//button[contains(text(), 'Subscribe')]"))
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
