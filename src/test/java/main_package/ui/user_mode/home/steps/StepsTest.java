package main_package.ui.user_mode.home.steps;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.ui.engine.OnixLocator;
import main_package.ui.user_mode.JsaLoginBaseTestRunner;
import main_package.ui.user_mode.page_objects.home_header.home.steps.Steps;

public class StepsTest extends JsaLoginBaseTestRunner {
    @BeforeClass
    public void openStepsPage() {
        homeLoginModePO.clickStepsLink();
    }
    @Test(dataProvider = "getStepsPageLocators")
    public void stepsTest(OnixLocator locator) {
        onixAssert.checkCountOfElementByLocator(locator, 1);
    }
    @DataProvider
    public Object[] getStepsPageLocators() {
        return mergeArrays(
                Steps.Locator.values(),
                Steps.HomeHeaderLocator.values()
        );
    }
}
