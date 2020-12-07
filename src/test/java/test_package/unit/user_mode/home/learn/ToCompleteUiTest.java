package test_package.unit.user_mode.home.learn;

import main_package.engine.OnixLocator;
import main_package.ui.___U_S_E_R___.general_parts.home.HomeHeaderPart;
import main_package.ui.___U_S_E_R___.page_objects.home_header.learn.ToComplete;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.engine.test_engine.JsaLoginBaseUiTestRunner;

public class ToCompleteUiTest extends JsaLoginBaseUiTestRunner {
    @BeforeClass
    public void goToCompletePage() {
        homeLoginModePO.clickLearnTab().clickToComplete();
    }
    @Test(dataProvider = "originalLocators")
    public void checkOriginalLocators(OnixLocator locator) {
        onixUiAssert.checkCountOfElementByLocator(locator, 1);
    }
    @DataProvider
    public Object[] originalLocators() {
        return mergeArrays(
                ToComplete.Locator.values(),
                HomeHeaderPart.HomeHeaderLocator.values()
        );
    }
}
