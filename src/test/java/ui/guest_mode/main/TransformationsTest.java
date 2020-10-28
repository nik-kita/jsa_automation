package ui.guest_mode.main;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ui.OnixAssert;
import ui.OnixTestRunner;
import ui.engine.OnixLocator;
import ui.guest_mode.general_parts.Footer;
import ui.guest_mode.general_parts.MainHeader;
import ui.guest_mode.page_objects.main.Transformations;

public class TransformationsTest extends OnixTestRunner {
    @BeforeClass
    public void goTransformationsPage() {
        openSite().goTransformationsPage();
    }

    @Test(dataProvider = "getTransformationsLocators")
    public void transformationsTest(OnixLocator locator) {
        onixAssert
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
