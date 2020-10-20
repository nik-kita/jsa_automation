package ui.guest_mode.page_objects;


import org.openqa.selenium.By;
import ui.BasePageObject;
import ui.engine.OnixLocator;
import ui.engine.OnixWebDriver;

public class ResetPassword extends BasePageObject {
    public ResetPassword(OnixWebDriver driver) {
        super(driver);
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
