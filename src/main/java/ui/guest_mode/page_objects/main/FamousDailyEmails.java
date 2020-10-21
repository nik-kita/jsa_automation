package ui.guest_mode.page_objects.main;

import org.openqa.selenium.By;
import ui.BasePageObject;
import ui.engine.OnixLocator;
import ui.engine.OnixWebDriver;

public class FamousDailyEmails extends BasePageObject {
    public FamousDailyEmails(OnixWebDriver driver) {
        super(driver);
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
