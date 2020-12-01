package main_package.ui.user_mode.main;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.engine.test_engine.OnixUiAssert;
import main_package.engine.OnixLocator;
import main_package.ui.user_mode.page_objects.main.Transformations;
import main_package.ui.user_mode.JsaLoginBaseTestRunner;

public class TransformationsTest extends JsaLoginBaseTestRunner {
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
