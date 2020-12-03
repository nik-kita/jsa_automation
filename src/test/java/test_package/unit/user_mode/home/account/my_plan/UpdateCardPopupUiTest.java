package test_package.unit.user_mode.home.account.my_plan;

import main_package.engine.OnixLocator;

import main_package.ui.user_mode.page_objects.home_header.home.account.my_plan.UpdateCardPopup;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.engine.test_engine.JsaLoginBaseUiTestRunner;

public class UpdateCardPopupUiTest extends JsaLoginBaseUiTestRunner {
    @BeforeClass
    public void openUpdateCardPopup() {
        homeLoginModePO.clickAccountIcon().clickUpdateCard();
    }
    @Test(dataProvider = "origin")
    public void updateCardPopupTest(OnixLocator locator) {
        onixUiAssert.checkCountOfElementByLocator(locator, 1);
    }
    @DataProvider
    public Object[] origin() {
        return UpdateCardPopup.Locator.values();
    }
}