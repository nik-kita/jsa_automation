package main_package.ui.user_mode.from_footer;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.engine.OnixLocator;
import main_package.ui.user_mode.JsaLoginBaseTestRunner;
import main_package.ui.user_mode.page_objects.from_footer.PrivacyPolicy;

public class PrivacyPolicyTest extends JsaLoginBaseTestRunner {
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

