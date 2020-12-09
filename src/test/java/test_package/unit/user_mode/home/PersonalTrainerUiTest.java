package test_package.unit.user_mode.home;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.engine.OnixLocator;
import main_package.ui.___U_S_E_R___.general_parts.home.HomeHeader;
import main_package.ui.___U_S_E_R___.page_objects.home_header.home.PersonalTrainer;
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
                HomeHeader.HomeHeaderLocator.values(),
                PersonalTrainer.Locator.values()
        );
    }
}
