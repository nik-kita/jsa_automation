package main_package.ui.user_mode.page_objects.main.pricing;


import main_package.engine.test_engine.FlyTester;
import org.openqa.selenium.By;
import main_package.ui.BasePageObject;
import main_package.engine.OnixLocator;
import main_package.engine.OnixWebDriver;
import main_package.ui.user_mode.general_parts.Footer;
import main_package.ui.user_mode.general_parts.MainHeader;
import main_package.ui.user_mode.page_objects.main.pricing.pricingplans.PricingPlans;

public class Pricing extends BasePageObject implements Footer, MainHeader {
    public Pricing(OnixWebDriver driver) {
        super(driver);
    }
    @Override
    public Pricing test(FlyTester flyTester) {
        flyTester.test();
        return this;
    }

    public PricingPlans goPricingPlans() {
        driver.findElement(Locator.GET_STARTED_LEFT).click();
        logger.debug("'PricingPlans' from 'Pricing'");
        return new PricingPlans(driver);
    }


    public enum Locator implements OnixLocator {
        SUBSCRIPTIONS_BUTTON(By.xpath("//*[contains(text(), 'Subscriptions')]")),
        BLOCKS_BUTTON(By.xpath("//*[contains(text(), 'Blocks')]")),
        GET_STARTED_LEFT(By.xpath("//div[@class='price_block']//div[contains(text(), 'Standard Plan')]/../..//a")),

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
