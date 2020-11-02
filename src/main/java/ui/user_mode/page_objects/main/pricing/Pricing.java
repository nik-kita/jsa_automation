package ui.user_mode.page_objects.main.pricing;


import org.openqa.selenium.By;
import ui.BasePageObject;
import ui.engine.OnixLocator;
import ui.engine.OnixWebDriver;
import ui.user_mode.general_parts.Footer;
import ui.user_mode.general_parts.MainHeader;
import ui.user_mode.page_objects.main.pricing.pricingplans.PricingPlans;

public class Pricing extends BasePageObject implements Footer, MainHeader {
    public Pricing(OnixWebDriver driver) {
        super(driver);
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
