package main_package.ui.user_mode.home.workouts;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.ui.engine.OnixLocator;
import main_package.ui.user_mode.JsaLoginBaseTestRunner;

import main_package.ui.user_mode.page_objects.home_header.workouts.Personalised;

public class PersonalisedTest extends JsaLoginBaseTestRunner {
    @BeforeClass
    public void goPersonalised() {
        homeLoginModePO.clickWorkoutsTab();
    }
    @Test(dataProvider = "getPersonalisedLocators")
    public void personalisedTest(OnixLocator locator) {
        onixAssert.checkCountOfElementByLocator(locator, 1);
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
