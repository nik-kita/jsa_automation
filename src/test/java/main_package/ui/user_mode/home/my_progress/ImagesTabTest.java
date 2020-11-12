package main_package.ui.user_mode.home.my_progress;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.ui.engine.OnixLocator;
import main_package.ui.user_mode.JsaLoginBaseTestRunner;
import main_package.ui.user_mode.page_objects.home_header.home.my_progress.ImagesTab;

public class ImagesTabTest extends JsaLoginBaseTestRunner {
    @BeforeClass
    public void openImagesTab() {
        homeLoginModePO.clickMyProgressLink().clickImagesTab();
    }
    @Test(dataProvider = "getImagesTabLocators")
    public void imagesTabTest(OnixLocator locator) {
        onixAssert.checkCountOfElementByLocator(locator, 1);
    }
    @DataProvider
    public Object[] getImagesTabLocators() {
        return mergeArrays(
                ImagesTab.Locator.values(),
                ImagesTab.HomeHeaderLocator.values()
        );
    }
}
