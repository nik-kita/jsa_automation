package test_package.unit.user_mode.home.learn;

import main_package.engine.OnixLocator;
import main_package.ui.___U_S_E_R___.general_parts.home.HomeHeader;
import main_package.ui.___U_S_E_R___.page_objects.home_header.learn.SingleLearnVideo;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.engine.test_engine.JsaLoginBaseUiTestRunner;

public class SingleLearnVideoUiTest extends JsaLoginBaseUiTestRunner {
    SingleLearnVideo singleLearnVideo;
    @BeforeClass
    public void openSingleLearnVideo() {
        singleLearnVideo = homeLoginModePO.clickLearnTab().clickVideo();
    }
    @Test(dataProvider = "getOriginalLocators")
    public void testOriginalLocators(OnixLocator locator) {
        onixUiAssert.checkCountOfElementByLocator(locator, 1);
    }
    @DataProvider
    public Object[] getOriginalLocators() {
        return mergeArrays(
                HomeHeader.HomeHeaderLocator.values(),
                SingleLearnVideo.Locator.values()
        );
    }
    @Test(dataProvider = "getDuplicateLocators")
    public void testDuplicatedLocators(OnixLocator locator) {
        onixUiAssert.checkMinimumOfElementsByLocator(locator, 1);
    }
    @DataProvider
    public Object[] getDuplicateLocators() {
        return SingleLearnVideo.Locators.values();
    }
}
