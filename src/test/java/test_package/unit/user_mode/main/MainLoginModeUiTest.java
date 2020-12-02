package test_package.unit.user_mode.main;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.engine.test_engine.OnixUiAssert;
import main_package.engine.OnixLocator;
import main_package.ui.user_mode.page_objects.main.Main;
import main_package.engine.test_engine.JsaLoginBaseUiTestRunner;

public class MainLoginModeUiTest extends JsaLoginBaseUiTestRunner {
    Main mainLoginModePO;
    @BeforeClass
    public void goMain() {
        mainLoginModePO = homeLoginModePO.goMainPage();
    }



    @Test(dataProvider = "getMainPageLocators")
    public void checkMainPageSameAsLogout(OnixLocator locator) {
        new OnixUiAssert(getDriver()).
                checkCountOfElementByLocator(locator, 1);
    }

    @DataProvider
    public Object[] getMainPageLocators() {
        return mergeArrays(
                Main.Locator.values(),
                Main.HeaderLocator.values(),
                Main.FooterLocator.values()
        );
    }



}
