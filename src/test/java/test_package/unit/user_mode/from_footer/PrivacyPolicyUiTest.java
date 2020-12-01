package main_package.ui.user_mode.from_footer;

import main_package.ui.user_mode.JsaLoginBaseUiTestRunner;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.engine.OnixLocator;
import main_package.ui.user_mode.page_objects.from_footer.PrivacyPolicy;

public class PrivacyPolicyUiTest extends JsaLoginBaseUiTestRunner {
    PrivacyPolicy privacyPolicy;
    @BeforeClass
    public void goPrivacyPolicy() {
        privacyPolicy = homeLoginModePO.goMainPage().goPrivacyPolicyFromFooter();
    }
    @Test(dataProvider = "getPrivacyPolicyLocators")
    public void privacyPolicyTest(OnixLocator locator) {
        onixUiAssert.checkCountOfElementByLocator(locator, 1);
    }
    @DataProvider
    public Object[] getPrivacyPolicyLocators() {
        return mergeArrays(
                PrivacyPolicy.FooterLocator.values(),
                PrivacyPolicy.HeaderLocator.values(),
                PrivacyPolicy.Locator.values()
        );
    }
}

