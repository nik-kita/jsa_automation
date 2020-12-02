package test_package.unit.user_mode.home.my_progress;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.engine.OnixLocator;
import main_package.ui.user_mode.page_objects.home_header.home.my_progress.ImagesTab;
import main_package.engine.test_engine.JsaLoginBaseUiTestRunner;

public class ImagesTabUiTest extends JsaLoginBaseUiTestRunner {
    @BeforeClass
    public void openImagesTab() {
        homeLoginModePO.clickMyProgressLink().clickImagesTab();
    }
    @Test(dataProvider = "getImagesTabLocators")
    public void imagesTabTest(OnixLocator locator) {
        onixUiAssert.checkCountOfElementByLocator(locator, 1);
    }
    @DataProvider
    public Object[] getImagesTabLocators() {
        return mergeArrays(
                ImagesTab.Locator.values(),
                ImagesTab.HomeHeaderLocator.values()
        );
    }
}
