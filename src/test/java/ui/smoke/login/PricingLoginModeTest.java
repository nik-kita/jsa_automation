package ui.smoke.login;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ui.OnixAssert;
import ui.engine.OnixLocator;
import ui.user_mode.page_objects.Pricing;

public class PricingLoginModeTest extends JsaLoginBaseTestRunner {
    @BeforeClass
    public void goPricingPage() {
        homeLoginModePO.goMainPage()
                .goPricingPage();
    }

    @Test(dataProvider = "getPricingLoginModePageLocators")
    public void pricingLoginModeTest(OnixLocator locator) {
        new OnixAssert(driver).checkCountOfElementByLocator(locator, 1);
    }
    @DataProvider
    public Object[] getPricingLoginModePageLocators() {
        return Pricing.Locator.values();
    }
}
