package main_package.ui.user_mode.home.steps;

import main_package.ui.engine.OnixAssert;
import main_package.ui.engine.OnixLocator;
import main_package.ui.user_mode.JsaLoginBaseTestRunner;
import main_package.ui.user_mode.page_objects.home_header.home.steps.EditTodayStepsPopup;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EditTodayStepsPopupTest extends JsaLoginBaseTestRunner {
    @BeforeClass
    public void goEditStepsPopup() {
        homeLoginModePO.clickStepsLink().clickEditTodayStepsIconButton();
    }

    @Test(dataProvider = "origin")
    public void testOriginLocatorsOfEditStepsPopup(OnixLocator locator) {
        new OnixAssert(driver).checkCountOfElementByLocator(locator, 1);
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
