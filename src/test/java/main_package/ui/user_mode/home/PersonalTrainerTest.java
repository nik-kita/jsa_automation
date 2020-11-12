package main_package.ui.user_mode.home;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.ui.engine.OnixLocator;
import main_package.ui.user_mode.JsaLoginBaseTestRunner;
import main_package.ui.user_mode.general_parts.home.HomeHeaderPart;
import main_package.ui.user_mode.page_objects.home_header.home.PersonalTrainer;

public class PersonalTrainerTest extends JsaLoginBaseTestRunner {
    @BeforeClass
    public void goPersonalTrainerPage() {
        homeLoginModePO.clickSupportButton();
    }

    @Test(dataProvider = "getPersonalTrainerPageLocators")
    public void personalTrainerTest(OnixLocator locator) {
        onixAssert.checkCountOfElementByLocator(locator, 1);
    }
    @DataProvider
    public Object[] getPersonalTrainerPageLocators() {
        return mergeArrays(
                HomeHeaderPart.HomeHeaderLocator.values(),
                PersonalTrainer.Locator.values()
        );
    }
}
