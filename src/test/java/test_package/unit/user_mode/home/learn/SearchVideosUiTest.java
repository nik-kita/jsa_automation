package test_package.unit.user_mode.home.learn;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.engine.OnixLocator;
import main_package.ui.user_mode.general_parts.home.HomeHeaderPart;
import main_package.ui.user_mode.page_objects.home_header.learn.SearchVideos;
import main_package.engine.test_engine.JsaLoginBaseUiTestRunner;

public class SearchVideosUiTest extends JsaLoginBaseUiTestRunner {
    @BeforeClass
    public void goSearchVideos() {
        homeLoginModePO.clickLearnTab().clickSearchIcon();
    }
    @Test(dataProvider = "getSearchVideosLocators")
    public void searchVideosTest(OnixLocator locator) {
        onixUiAssert.checkCountOfElementByLocator(locator, 1);
    }
    @DataProvider
    public Object[] getSearchVideosLocators() {
        return mergeArrays(
                HomeHeaderPart.HomeHeaderLocator.values(),
                SearchVideos.Locator.values()
        );
    }
}
