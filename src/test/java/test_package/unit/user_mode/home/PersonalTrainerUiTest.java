package test_package.unit.user_mode.home;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.engine.OnixLocator;
import main_package.ui.user_mode.general_parts.home.HomeHeaderPart;
import main_package.ui.user_mode.page_objects.home_header.home.PersonalTrainer;
import main_package.engine.test_engine.JsaLoginBaseUiTestRunner;

public class PersonalTrainerUiTest extends JsaLoginBaseUiTestRunner {
    @BeforeClass
    public void goPersonalTrainerPage() {
        homeLoginModePO.clickSupportButton();
    }

    @Test(dataProvider = "getPersonalTrainerPageLocators")
    public void personalTrainerTest(OnixLocator locator) {
        onixUiAssert.checkCountOfElementByLocator(locator, 1);
    }
    @DataProvider
    public Object[] getPersonalTrainerPageLocators() {
        return mergeArrays(
                HomeHeaderPart.HomeHeaderLocator.values(),
                PersonalTrainer.Locator.values()
        );
    }
}
