package test_package.unit.user_mode.home.account.my_plan;

import main_package.engine.OnixLocator;
import main_package.ui.user_mode.JsaLoginBaseUiTestRunner;
import main_package.ui.user_mode.page_objects.home_header.home.account.my_plan.ConfirmCancelPopup;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ConfirmPopupUiTest extends JsaLoginBaseUiTestRunner {
    @BeforeClass
    public void openConfirmButton() {
        homeLoginModePO.clickAccountIcon().clickCancelSubscriptionPlan();
    }
    @Test(dataProvider = "origin")
    public void testCancelPopup(OnixLocator locator) {
        onixUiAssert.checkCountOfElementByLocator(locator, 1);
    }
    @DataProvider
    public Object[] origin() {
        return ConfirmCancelPopup.Locator.values();
    }
}
