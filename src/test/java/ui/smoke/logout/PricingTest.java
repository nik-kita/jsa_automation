package ui.smoke.logout;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ui.OnixAssert;
import ui.OnixTestRunner;
import ui.engine.OnixLocator;
import ui.guest_mode.page_objects.main.Pricing;

public class PricingTest extends OnixTestRunner {

    @BeforeClass
    public void goPricingPage() {
        openSite().goPricingPage();
    }

    @Test(dataProvider = "getPricingLocators")
    public void pricingTest(OnixLocator locator) {
        new OnixAssert(getDriver()).checkCountOfElementByLocator(locator, 1);
    }

    @DataProvider
    public Object[] getPricingLocators() {
        return Pricing.Locator.values();
    }
}
