package main_package.ui.user_mode.home.learn;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.engine.test_engine.OnixUiAssert;
import main_package.engine.OnixLocator;
import main_package.ui.user_mode.JsaLoginBaseTestRunner;
import main_package.ui.user_mode.general_parts.home.HomeHeaderPart;
import main_package.ui.user_mode.general_parts.home.HomePart;
import main_package.ui.user_mode.page_objects.home_header.learn.Learn;

public class LearnTest extends JsaLoginBaseTestRunner {
    @BeforeClass
    public void goLearn() {
        homeLoginModePO.clickLearnTab();
    }
    @Test(dataProvider = "getLearnLocators")
    public void learnPageTest(OnixLocator locator) {
        new OnixUiAssert(driver).checkCountOfElementByLocator(locator, 1);
    }
    @DataProvider
    public Object[] getLearnLocators() {
        return mergeArrays(
                HomeHeaderPart.HomeHeaderLocator.values(),
                Learn.Locator.values(),
                HomePart.HomeFlyLocator.values()
        );
    }
    @Test(dataProvider = "getSameLocators")
    public void learnPageNotOriginItemsTest(OnixLocator locator) {
        onixUiAssert.checkMinimumOfElementsByLocator(locator, 1);
    }
    @DataProvider
    public Object[] getSameLocators() {
        return Learn.Locators.values();
    }
}
