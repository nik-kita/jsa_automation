package ui.smoke.logout;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ui.OnixAssert;
import ui.OnixTestRunner;
import ui.engine.OnixLocator;
import ui.guest_mode.page_objects.Transformations;

public class TransformationsTest extends OnixTestRunner {
    @BeforeClass
    public void goTransformationsPage() {
        openSite().goTransformationsPage();
    }

    @Test(dataProvider = "getTransformationsLocators")
    public void transformationsTest(OnixLocator locator) {
        new OnixAssert(getDriver())
                .checkCountOfElementByLocator(locator, 1);
    }

    @DataProvider
    public Object[] getTransformationsLocators() {
        return Transformations.Locator.values();
    }
}
