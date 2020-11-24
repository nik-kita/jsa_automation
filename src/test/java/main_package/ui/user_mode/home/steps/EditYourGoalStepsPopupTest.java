package main_package.ui.user_mode.home.steps;

import main_package.ui.engine.OnixAssert;
import main_package.ui.engine.OnixLocator;
import main_package.ui.user_mode.JsaLoginBaseTestRunner;
import main_package.ui.user_mode.page_objects.home_header.home.steps.EditYourGoalStepsPopup;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EditYourGoalStepsPopupTest extends JsaLoginBaseTestRunner {
    @BeforeClass
    public void goEditYourGoalStepsPopup() {
        homeLoginModePO.clickStepsLink().clickEditYourStepsGoalIconPenButton();
    }

    @Test(dataProvider = "origin")
    public void testOriginLocatorsOfEditYourGoalStepsPopup(OnixLocator locator) {
        new OnixAssert(driver).checkCountOfElementByLocator(locator, 1);
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