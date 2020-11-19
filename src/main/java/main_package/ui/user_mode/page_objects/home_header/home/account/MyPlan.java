package main_package.ui.user_mode.page_objects.home_header.home.account;

import main_package.ui.BasePageObject;
import main_package.ui.engine.OnixLocator;
import main_package.ui.engine.OnixWebDriver;
import main_package.ui.user_mode.general_parts.Footer;
import main_package.ui.user_mode.general_parts.home.account.AccountHeader;
import main_package.ui.user_mode.general_parts.home.account.AccountSidebar;
import org.openqa.selenium.By;

public class MyPlan extends BasePageObject implements Footer, AccountHeader, AccountSidebar {
    public MyPlan(OnixWebDriver driver) {
        super(driver);
    }


    public enum Locator implements OnixLocator {
        CHANGE_PLAN_LINK(By.xpath("//a[text() = 'Change plan']")),
        CANCEL_SUBSCRIPTION_PLAN_LINK(By.cssSelector(".my-plan__action--cancel")),
        UPDATE_CARD_LINK(By.cssSelector(".my-plan__action--update")),
        COUPON_CODE_INPUT(By.cssSelector("[name='coupon']")),
        REDEEM_BUTTON(By.cssSelector("#button-addon2")),
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
