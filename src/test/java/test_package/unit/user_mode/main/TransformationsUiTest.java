package test_package.unit.user_mode.main;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.engine.test_engine.OnixUiAssert;
import main_package.engine.OnixLocator;
import main_package.ui.___U_S_E_R___.page_objects.main.Transformations;
import main_package.engine.test_engine.JsaLoginBaseUiTestRunner;

public class TransformationsUiTest extends JsaLoginBaseUiTestRunner {
    @BeforeClass
    public void goTransformationsPage() {
        homeLoginModePO.goMainPage().goTransformationsPage();
    }

    @Test(dataProvider = "getTransformationsLocators")
    public void transformationsTest(OnixLocator locator) {
        new OnixUiAssert(getDriver())
                .checkCountOfElementByLocator(locator, 1);
    }

    @DataProvider
    public Object[] getTransformationsLocators() {
        return mergeArrays(
                Transformations.Locator.values(),
                Transformations.HeaderLocator.values(),
                Transformations.FooterLocator.values()
        );
    }
}
