package test_package.unit.guest_mode.main;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.engine.test_engine.OnixUiTestRunner;
import main_package.engine.OnixLocator;
import main_package.ui.guest_mode.page_objects.main.Transformations;

public class TransformationsUiTest extends OnixUiTestRunner {
    @BeforeClass
    public void goTransformationsPage() {
        openSite().clickHeaderTransformations();
    }

    @Test(dataProvider = "getTransformationsLocators")
    public void transformationsTest(OnixLocator locator) {
        onixUiAssert
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
