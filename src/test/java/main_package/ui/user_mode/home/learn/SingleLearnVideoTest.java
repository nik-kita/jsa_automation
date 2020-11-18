package main_package.ui.user_mode.home.learn;

import main_package.ui.engine.OnixLocator;
import main_package.ui.user_mode.JsaLoginBaseTestRunner;
import main_package.ui.user_mode.general_parts.home.HomeHeaderPart;
import main_package.ui.user_mode.page_objects.home_header.learn.SingleLearnVideo;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SingleLearnVideoTest extends JsaLoginBaseTestRunner {
    SingleLearnVideo singleLearnVideo;
    @BeforeClass
    public void openSingleLearnVideo() {
        singleLearnVideo = homeLoginModePO.clickLearnTab().clickVideo();
    }
    @Test(dataProvider = "getOriginalLocators")
    public void testOriginalLocators(OnixLocator locator) {
        onixAssert.checkCountOfElementByLocator(locator, 1);
    }
    @DataProvider
    public Object[] getOriginalLocators() {
        return mergeArrays(
                HomeHeaderPart.HomeHeaderLocator.values(),
                SingleLearnVideo.Locator.values()
        );
    }
    @Test(dataProvider = "getDuplicateLocators")
    public void testDuplicatedLocators(OnixLocator locator) {
        onixAssert.checkMinimumOfElementsByLocator(locator, 1);
    }
    @DataProvider
    public Object[] getDuplicateLocators() {
        return SingleLearnVideo.Locators.values();
    }
}
