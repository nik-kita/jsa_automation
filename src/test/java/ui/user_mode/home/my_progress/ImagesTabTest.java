package ui.user_mode.home.my_progress;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ui.engine.OnixLocator;
import ui.user_mode.JsaLoginBaseTestRunner;
import ui.user_mode.general_parts.home.HomeHeaderPart;
import ui.user_mode.page_objects.home_header.home.my_progress.ImagesTab;

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
