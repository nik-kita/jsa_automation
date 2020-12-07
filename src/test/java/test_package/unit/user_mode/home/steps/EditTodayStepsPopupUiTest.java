package test_package.unit.user_mode.home.steps;

import main_package.engine.test_engine.OnixUiAssert;
import main_package.engine.OnixLocator;
import main_package.ui.___U_S_E_R___.page_objects.home_header.home.steps.EditTodayStepsPopup;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.engine.test_engine.JsaLoginBaseUiTestRunner;

public class EditTodayStepsPopupUiTest extends JsaLoginBaseUiTestRunner {
    @BeforeClass
    public void goEditStepsPopup() {
        homeLoginModePO.clickStepsLink().clickEditTodayStepsIconButton();
    }

    @Test(dataProvider = "origin")
    public void testOriginLocatorsOfEditStepsPopup(OnixLocator locator) {
        new OnixUiAssert(driver).checkCountOfElementByLocator(locator, 1);
    }

    @DataProvider
    public Object[] origin() {
        return EditTodayStepsPopup.Locator.values();
    }

//    @Test(dataProvider = "notOriginal")
//    public void testNotOriginalLocatorsOfEditStepsPopup(OnixLocator locator) {
//        onixAssert.checkMinimumOfElementsByLocator(locator, 1);
//    }
//
//    @DataProvider
//    public Object[] notOriginal() {
//        return EditStepsPopup.Locators.values();
//    }
}
