package ui.smoke.login.learn;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ui.OnixAssert;
import ui.engine.OnixLocator;
import ui.smoke.login.JsaLoginBaseTestRunner;
import ui.user_mode.general_parts.home.HomeHeaderPart;
import ui.user_mode.general_parts.home.HomePart;
import ui.user_mode.page_objects.home.learn.Learn;

public class LearnTest extends JsaLoginBaseTestRunner {
    @BeforeClass
    public void goLearn() {
        homeLoginModePO.clickLearnTab();
    }
    @Test(dataProvider = "getLearnLocators")
    public void learnPageTest(OnixLocator locator) {
        new OnixAssert(driver).checkCountOfElementByLocator(locator, 1);
    }
    @DataProvider
    public Object[] getLearnLocators() {
        return mergeArrays(
                HomeHeaderPart.HomeHeaderLocator.values(),
                Learn.Locator.values(),
                HomePart.HomeFlyLocator.values()
        );
    }
}
