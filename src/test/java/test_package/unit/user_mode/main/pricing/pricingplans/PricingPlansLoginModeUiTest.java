package test_package.unit.user_mode.main.pricing.pricingplans;


import main_package.ui.user_mode.JsaLoginBaseUiTestRunner;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.engine.test_engine.OnixUiAssert;
import main_package.engine.OnixLocator;
import main_package.ui.user_mode.page_objects.main.pricing.pricingplans.PricingPlans;

public class PricingPlansLoginModeUiTest extends JsaLoginBaseUiTestRunner {
    PricingPlans pricingPlansLoginModePO;
    @BeforeClass
    public void goPricingPlansLoginModePage() {
        pricingPlansLoginModePO = homeLoginModePO.goMainPage()
                .goPricingPage()
                .goPricingPlans();
    }

    @Test(dataProvider = "getPricingPlansLoginModeLocators")
    public void pricingPlansLoginModeTest(OnixLocator locator) {
        new OnixUiAssert(driver).checkCountOfElementByLocator(locator, 1);
    }

    @DataProvider
    public Object[] getPricingPlansLoginModeLocators() {
        return PricingPlans.Locator.values();
    }

    @Test(dataProvider = "getBlockTabLocators")
    public void blockTab(OnixLocator locator) {
        pricingPlansLoginModePO.clickBlocksButton();
        onixUiAssert.softCheckCountOfElementByLocator(locator, 1);
        pricingPlansLoginModePO.clickSubscriptionsButton();
        onixUiAssert.assertAll();
    }

    @DataProvider
    public Object[] getBlockTabLocators() {
        return PricingPlans.BlocksTabLocator.values();
    }
}
