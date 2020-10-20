package ui.smoke.login.home.learn;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ui.OnixAssert;
import ui.engine.OnixLocator;
import ui.smoke.login.JsaLoginBaseTestRunner;
import ui.user_mode.general_parts.home.HomeHeaderPart;
import ui.user_mode.page_objects.home.learn.SearchVideos;

public class SearchVideosTest extends JsaLoginBaseTestRunner {
    @BeforeClass
    public void goSearchVideos() {
        homeLoginModePO.clickLearnTab().clickSearchIcon();
    }
    @Test(dataProvider = "getSearchVideosLocators")
    public void searchVideosTest(OnixLocator locator) {
        new OnixAssert(driver).checkCountOfElementByLocator(locator, 1);
    }
    @DataProvider
    public Object[] getSearchVideosLocators() {
        return mergeArrays(
                HomeHeaderPart.HomeHeaderLocator.values(),
                SearchVideos.Locator.values()
        );
    }
}
