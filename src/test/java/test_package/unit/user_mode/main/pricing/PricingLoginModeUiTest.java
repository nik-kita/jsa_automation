package test_package.unit.user_mode.main.pricing;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.engine.OnixLocator;
import main_package.ui.___U_S_E_R___.page_objects.main.pricing.Pricing;
import main_package.engine.test_engine.JsaLoginBaseUiTestRunner;

public class PricingLoginModeUiTest extends JsaLoginBaseUiTestRunner {
    @BeforeClass
    public void goPricingPage() {
        homeLoginModePO.goMainPage()
                .goPricingPage();
    }

    @Test(dataProvider = "getPricingLoginModePageLocators")
    public void pricingLoginModeTest(OnixLocator locator) {
        onixUiAssert.checkCountOfElementByLocator(locator, 1);
    }
    @DataProvider
    public Object[] getPricingLoginModePageLocators() {
        return Pricing.Locator.values();
    }
}
