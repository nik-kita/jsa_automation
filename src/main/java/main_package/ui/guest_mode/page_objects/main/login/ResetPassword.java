package main_package.ui.guest_mode.page_objects.main.login;


import main_package.engine.test_engine.FlyTester;
import org.openqa.selenium.By;
import main_package.ui.BasePageObject;
import main_package.engine.OnixLocator;
import main_package.engine.OnixWebDriver;
import main_package.ui.guest_mode.general_parts.Footer;
import main_package.ui.guest_mode.general_parts.MainHeader;

public class ResetPassword extends BasePageObject implements Footer, MainHeader {
    public ResetPassword(OnixWebDriver driver) {
        super(driver);
    }
    @Override
    public ResetPassword test(FlyTester flyTester) {
        flyTester.test();
        return this;
    }

    public enum Locator implements OnixLocator {
        EMAIL_INPUT(By.cssSelector("input#id_email")),
        ENTER_BUTTON(By.cssSelector("input[type='submit']"))
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
