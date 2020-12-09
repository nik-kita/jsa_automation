package test_package.unit.user_mode.home.learn;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.engine.OnixLocator;
import main_package.ui.___U_S_E_R___.general_parts.home.HomeHeader;
import main_package.ui.___U_S_E_R___.page_objects.home_header.learn.SearchVideos;
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
                HomeHeader.HomeHeaderLocator.values(),
                SearchVideos.Locator.values()
        );
    }
}
