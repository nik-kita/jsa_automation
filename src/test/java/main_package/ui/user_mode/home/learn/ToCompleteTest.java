package main_package.ui.user_mode.home.learn;

import main_package.ui.engine.OnixLocator;
import main_package.ui.user_mode.JsaLoginBaseTestRunner;
import main_package.ui.user_mode.general_parts.home.HomeHeaderPart;
import main_package.ui.user_mode.page_objects.home_header.learn.ToComplete;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ToCompleteTest extends JsaLoginBaseTestRunner {
    @BeforeClass
    public void goToCompletePage() {
        homeLoginModePO.clickLearnTab().clickToComplete();
    }
    @Test(dataProvider = "originalLocators")
    public void checkOriginalLocators(OnixLocator locator) {
        onixAssert.checkCountOfElementByLocator(locator, 1);
    }
    @DataProvider
    public Object[] originalLocators() {
        return mergeArrays(
                ToComplete.Locator.values(),
                HomeHeaderPart.HomeHeaderLocator.values()
        );
    }
}
