package ui.user_mode.page_objects;


import org.openqa.selenium.By;
import ui.BasePageObject;
import ui.engine.OnixLocator;
import ui.engine.OnixWebDriver;
import ui.user_mode.general_parts.Footer;

public class PricingPlans extends BasePageObject implements Footer {
    public PricingPlans(OnixWebDriver driver) {
        super(driver);
//        try {
//            Thread.sleep(4000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        if(driver.findElements(PricingPlansLoginModePO.BlocksTabLocator.BUY_NOW_BUTTON).size() > 0) {
//            this.clickSubscriptionsButton();
//        }
    }

    public Home goHome() {
        driver.findElement(Locator.HOME_HEADER_BUTTON).click();
        return new Home(driver);
    }

    public PaymentMethodPopup subscribeStandard() {
        driver.scrollPageDown();
        driver.findElement(Locator.SUBSCRIBE_BTN_STANDARD_PLAN).click();
        return new PaymentMethodPopup(driver);
    }
    public PaymentMethodPopup subscribePremium() {
        driver.scrollPageDown();
        driver.findElement(Locator.SUBSCRIBE_BTN_PREMIUM_PLAN).click();
        return new PaymentMethodPopup(driver);
    }

    public PaymentMethodPopup buyNow() {
        clickBlocksButton();
        driver.findElement(BlocksTabLocator.BUY_NOW_BUTTON).click();
        return new PaymentMethodPopup(driver);
    }
    public PricingPlans clickBlocksButton() {
        driver.scrollPageUp();
        driver.findElement(Locator.BLOCKS_BUTTON).click();
        return this;
    }

    public PricingPlans clickSubscriptionsButton() {
        driver.scrollPageDown();
        driver.findElement(Locator.SUBSCRIPTIONS_BUTTON).click();
        return this;
    }


    public enum Locator implements OnixLocator {
        JSA_LOGO(By.cssSelector("a[href='/'] img")),
        HOME_HEADER_BUTTON(By.cssSelector(".nav [href='/users/']")),
        ACCOUNT_HEADER_BUTTON(By.cssSelector(".nav [href='/users/account/']")),
        PRICING_PLANS_HEADER_BUTTON(By.cssSelector(".nav [href='/users/pricing/']")),
        LOGOUT_BUTTON(By.cssSelector(".login[href='/accounts/logout']")),
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
