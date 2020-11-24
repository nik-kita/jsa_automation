package main_package.ui.user_mode.main.pricing.pricingplans;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.ui.engine.OnixAssert;
import main_package.ui.engine.OnixLocator;
import main_package.ui.user_mode.JsaLoginBaseTestRunner;
import main_package.ui.user_mode.page_objects.main.pricing.pricingplans.PricingPlans;

public class PricingPlansLoginModeTest extends JsaLoginBaseTestRunner {
    PricingPlans pricingPlansLoginModePO;
    @BeforeClass
    public void goPricingPlansLoginModePage() {
        pricingPlansLoginModePO = homeLoginModePO.goMainPage()
                .goPricingPage()
                .goPricingPlans();
    }

    @Test(dataProvider = "getPricingPlansLoginModeLocators")
    public void pricingPlansLoginModeTest(OnixLocator locator) {
        new OnixAssert(driver).checkCountOfElementByLocator(locator, 1);
    }

    @DataProvider
    public Object[] getPricingPlansLoginModeLocators() {
        return PricingPlans.Locator.values();
    }

    @Test(dataProvider = "getBlockTabLocators")
    public void blockTab(OnixLocator locator) {
        pricingPlansLoginModePO.clickBlocksButton();
        onixAssert.softCheckCountOfElementByLocator(locator, 1);
        pricingPlansLoginModePO.clickSubscriptionsButton();
        onixAssert.assertAll();
    }

    @DataProvider
    public Object[] getBlockTabLocators() {
        return PricingPlans.BlocksTabLocator.values();
    }
}
