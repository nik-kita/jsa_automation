package test_package.unit.user_mode.home.steps;

import main_package.engine.test_engine.OnixUiAssert;
import main_package.engine.OnixLocator;
import main_package.ui.user_mode.page_objects.home_header.home.steps.EditYourGoalStepsPopup;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.engine.test_engine.JsaLoginBaseUiTestRunner;

public class EditYourGoalStepsPopupUiTest extends JsaLoginBaseUiTestRunner {
    @BeforeClass
    public void goEditYourGoalStepsPopup() {
        homeLoginModePO.clickStepsLink().clickEditYourStepsGoalIconPenButton();
    }

    @Test(dataProvider = "origin")
    public void testOriginLocatorsOfEditYourGoalStepsPopup(OnixLocator locator) {
        new OnixUiAssert(driver).checkCountOfElementByLocator(locator, 1);
    }

    @DataProvider
    public Object[] origin() {
        return EditYourGoalStepsPopup.Locator.values();
    }

//    @Test(dataProvider = "notOriginal")
//    public void testNotOriginalLocatorsOfEditYourGoalStepsPopup(OnixLocator locator) {
//        onixAssert.checkMinimumOfElementsByLocator(locator, 1);
//    }
//
//    @DataProvider
//    public Object[] notOriginal() {
//        return EditYourGoalStepsPopup.Locators.values();
//    }
}