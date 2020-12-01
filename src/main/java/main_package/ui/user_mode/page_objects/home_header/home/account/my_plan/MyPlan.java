package main_package.ui.user_mode.page_objects.home_header.home.account.my_plan;

import main_package.ui.BasePageObject;
import main_package.engine.test_engine.FlyTester;
import main_package.engine.OnixLocator;
import main_package.engine.OnixWebDriver;
import main_package.ui.user_mode.general_parts.Footer;
import main_package.ui.user_mode.general_parts.home.account.AccountHeader;
import main_package.ui.user_mode.general_parts.home.account.AccountSidebar;
import main_package.ui.user_mode.page_objects.main.pricing.pricingplans.PricingPlans;
import org.openqa.selenium.By;

public class MyPlan extends BasePageObject implements Footer, AccountHeader, AccountSidebar {
    public MyPlan(OnixWebDriver driver) {
        super(driver);
    }
    @Override
    public MyPlan test(FlyTester flyTester) {
        flyTester.test();
        return this;
    }

    public PricingPlans clickChangePlan() {
        driver.findElement(Locator.CHANGE_PLAN_LINK).click();
        return new PricingPlans(driver);
    }

    public ConfirmCancelPopup clickCancelSubscriptionPlan() {
        driver.findElement(Locator.CANCEL_SUBSCRIPTION_PLAN_LINK).click();
        return new ConfirmCancelPopup(driver);
    }

    public UpdateCardPopup clickUpdateCard() {
        driver.waitToClick(Locator.UPDATE_CARD_LINK).click();
        return new UpdateCardPopup(driver);
    }

    public MyPlan clickRedeem(String code) {
        driver.findElement(Locator.COUPON_CODE_INPUT).sendKeys(code);
        driver.findElement(Locator.REDEEM_BUTTON).click();
        driver.alertAccept();
        return this;
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
