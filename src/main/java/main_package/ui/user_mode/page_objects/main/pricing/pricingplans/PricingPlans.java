package main_package.ui.user_mode.page_objects.main.pricing.pricingplans;


import main_package.ui.engine.FlyTester;
import org.openqa.selenium.By;
import main_package.ui.BasePageObject;
import main_package.ui.engine.OnixLocator;
import main_package.ui.engine.OnixWebDriver;
import main_package.ui.user_mode.general_parts.Footer;
import main_package.ui.user_mode.general_parts.home.account.AccountHeader;
import main_package.ui.user_mode.page_objects.home_header.home.Home;

public class PricingPlans extends BasePageObject implements Footer, AccountHeader {

    OnixLocator activeBlockButton = makeOnixLocator(By.xpath("//*[contains(text(), 'Blocks')][@class='active']"), this.getClass());

    public PricingPlans(OnixWebDriver driver) {
        super(driver);
//        if(driver.isElementPresent(activeBlockButton)) {
//            clickSubscriptionsButton();
//        }
    }
    @Override
    public PricingPlans test(FlyTester flyTester) {
        flyTester.test();
        return this;
    }

    public Home goHome() {
        driver.findElement(AccountHeaderLocator.HOME_HEADER_BUTTON).click();
        logger.debug("'Home' from account header");
        return new Home(driver);
    }

    public PaymentMethodPopup subscribeStandard() {
        driver.scrollPageDown();
        driver.findElement(Locator.SUBSCRIBE_BTN_STANDARD_PLAN).click();
        logger.debug("standard 'PaymentMethodPopup' from 'PricingPlans'");
        return new PaymentMethodPopup(driver);
    }
    public PaymentMethodPopup subscribePremium() {
        driver.scrollPageDown();
        driver.findElement(Locator.SUBSCRIBE_BTN_PREMIUM_PLAN).click();
        logger.debug("premium 'PaymentMethodPopup' from 'PricingPlans'");
        return new PaymentMethodPopup(driver);
    }

    public PaymentMethodPopup buyNow() {
        clickBlocksButton();
        driver.scrollPageDown();
        driver.findElement(BlocksTabLocator.BUY_NOW_BUTTON).click();
        logger.debug("block 'PaymentMethodPopup' from 'PricingPlans'");
        return new PaymentMethodPopup(driver);
    }
    public PricingPlans clickBlocksButton() {
        driver.scrollPageUp();
        driver.findElement(Locator.BLOCKS_BUTTON).click();
        return this;
    }

    public PricingPlans clickSubscriptionsButton() {
        driver.scrollPageUp();
        driver.findElement(Locator.SUBSCRIPTIONS_BUTTON).click();
        return this;
    }


    public enum Locator implements OnixLocator {
        SUBSCRIPTIONS_BUTTON(By.xpath("//*[contains(text(), 'Subscriptions')]")),
        BLOCKS_BUTTON(By.xpath("//*[contains(text(), 'Blocks')]")),
        SUBSCRIBE_BTN_STANDARD_PLAN(By.id("standardSubscriptionButton")),
        SUBSCRIBE_BTN_PREMIUM_PLAN(By.id("premiumSubscriptionButton")),

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
    public enum BlocksTabLocator implements OnixLocator {
        BUY_NOW_BUTTON(By.cssSelector("#premiumBlockButton")),

        ;

        private By path;

        BlocksTabLocator(By path) {
            this.path = path;
        }
        @Override
        public By getPath() {
            return path;
        }

    }
}
