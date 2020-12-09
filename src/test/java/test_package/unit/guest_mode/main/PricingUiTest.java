package test_package.unit.guest_mode.main;

import main_package.engine.test_engine.OnixUiTestRunner;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.engine.OnixLocator;
import main_package.ui.___G_U_E_S_T___.page_objects.main.Pricing;

public class PricingUiTest extends OnixUiTestRunner {

    @BeforeClass
    public void goPricingPage() {
        openSite().clickHeaderPricing();
    }

    @Test(dataProvider = "getPricingLocators")
    public void pricingTest(OnixLocator locator) {
        onixUiAssert.checkCountOfElementByLocator(locator, 1);
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
