package ui.guest_mode.page_objects.main;


import org.openqa.selenium.By;
import ui.BasePageObject;
import ui.engine.OnixLocator;
import ui.engine.OnixWebDriver;
import ui.guest_mode.general_parts.Footer;
import ui.guest_mode.general_parts.MainHeader;

public class Challenge extends BasePageObject implements Footer, MainHeader {
    public Challenge(OnixWebDriver driver) {
        super(driver);
    }


    public enum Locator implements OnixLocator {
        CREATE_ACCOUNT_BUTTON_INNER_PAGE(By.cssSelector(".inner_page a[href='/users/register/']")),
        EMAIL_INPUT_INNER_PAGE(By.cssSelector("input[name='email']")),
        SIGN_UP_BUTTON_INNER_PAGE(By.cssSelector("button[onclick='submitRegisterInterest()']")),
        PREMIUM_PLAN_LINK(By.cssSelector("[href='/users/pricing/']")),



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
