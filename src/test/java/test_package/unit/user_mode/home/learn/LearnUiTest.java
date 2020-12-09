package test_package.unit.user_mode.home.learn;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.engine.test_engine.OnixUiAssert;
import main_package.engine.OnixLocator;
import main_package.ui.___U_S_E_R___.general_parts.home.HomeHeader;
import main_package.ui.___U_S_E_R___.general_parts.home.HomePart;
import main_package.ui.___U_S_E_R___.page_objects.home_header.learn.Learn;
import main_package.engine.test_engine.JsaLoginBaseUiTestRunner;

public class LearnUiTest extends JsaLoginBaseUiTestRunner {
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
                HomeHeader.HomeHeaderLocator.values(),
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
