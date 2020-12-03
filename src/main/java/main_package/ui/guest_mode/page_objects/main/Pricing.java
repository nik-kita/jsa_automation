package main_package.ui.guest_mode.page_objects.main;


import main_package.engine.test_engine.FlyTester;
import main_package.engine.test_engine.OnixUiAssert;
import org.openqa.selenium.By;
import main_package.ui.BasePageObject;
import main_package.engine.OnixLocator;
import main_package.engine.OnixWebDriver;
import main_package.ui.guest_mode.general_parts.Footer;
import main_package.ui.guest_mode.general_parts.MainHeader;

public class Pricing extends BasePageObject implements MainHeader, Footer {

    public Pricing(OnixWebDriver driver) {
        super(driver);
        logger.debug("'Pricing' page is open.");
    }
    public Pricing check(OnixUiAssert onixUiAssert) {
        for(OnixLocator l : OnixUiAssert.mergeArrays(
                Pricing.Locator.values(),
                MainHeader.HeaderLocator.values(),
                Footer.FooterLocator.values()
        )) {
            onixUiAssert.softCheckCountOfElementByLocator(l, 1);
        }
        return this;
    }
    @Override
    public Pricing test(FlyTester flyTester) {
        flyTester.test();
        return this;
    }

    public enum Locator implements OnixLocator {
        GET_STARTED_LEFT(By.xpath("//div[@class='price_block']//div[contains(text(), 'Standard Plan')]/../..//a")),
        //TODO there are absolute same 2 links GET_STARTED_RIGHT(By.xpath("//div[@class='price_block']//div[contains(text(), 'Premium Plan')]/../..//a")),
        SUBSCRIPTIONS_BUTTON(By.xpath("//*[contains(text(), 'Subscriptions')]")),
        BLOCKS_BUTTON(By.xpath("//*[contains(text(), 'Blocks')]")),

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

