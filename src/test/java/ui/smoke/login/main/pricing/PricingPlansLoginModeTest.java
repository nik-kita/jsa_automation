package ui.smoke.login.main.pricing;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ui.OnixAssert;
import ui.engine.OnixLocator;
import ui.smoke.login.JsaLoginBaseTestRunner;
import ui.user_mode.page_objects.main.pricing.pricingplans.PricingPlans;

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
        SoftAssert softAssert = new SoftAssert();
        new OnixAssert(driver).softCheckCountOfElementByLocator(locator, 1, softAssert);
        pricingPlansLoginModePO.clickSubscriptionsButton();
        softAssert.assertAll();
    }

    @DataProvider
    public Object[] getBlockTabLocators() {
        return PricingPlans.BlocksTabLocator.values();
    }
}
