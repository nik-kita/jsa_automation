package main_package.ui.guest_mode.main;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test_package.test_engine.OnixTestRunner;
import main_package.ui.engine.OnixLocator;
import main_package.ui.guest_mode.page_objects.main.Pricing;

public class PricingTest extends OnixTestRunner {

    @BeforeClass
    public void goPricingPage() {
        openSite().goPricingPage();
    }

    @Test(dataProvider = "getPricingLocators")
    public void pricingTest(OnixLocator locator) {
        onixAssert.checkCountOfElementByLocator(locator, 1);
    }

    @DataProvider
    public Object[] getPricingLocators() {
        return mergeArrays(
                Pricing.Locator.values(),
                Pricing.FooterLocator.values(),
                Pricing.HeaderLocator.values()
        );
    }
}