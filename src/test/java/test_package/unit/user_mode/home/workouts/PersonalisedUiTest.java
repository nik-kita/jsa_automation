package test_package.unit.user_mode.home.workouts;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.engine.OnixLocator;

import main_package.ui.___U_S_E_R___.page_objects.home_header.workouts.Personalised;
import main_package.engine.test_engine.JsaLoginBaseUiTestRunner;

public class PersonalisedUiTest extends JsaLoginBaseUiTestRunner {
    @BeforeClass
    public void goPersonalised() {
        homeLoginModePO.clickWorkoutsTab();
    }
    @Test(dataProvider = "getPersonalisedLocators")
    public void personalisedTest(OnixLocator locator) {
        onixUiAssert.checkCountOfElementByLocator(locator, 1);
    }
    @DataProvider
    public Object[] getPersonalisedLocators() {
        return mergeArrays(
                Personalised.HomeFlyLocator.values(),
                Personalised.HomeHeaderLocator.values(),
                Personalised.Locator.values()
        );
    }
}
