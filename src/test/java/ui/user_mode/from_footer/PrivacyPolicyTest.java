package ui.user_mode.from_footer;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ui.engine.OnixLocator;
import ui.user_mode.JsaLoginBaseTestRunner;
import ui.user_mode.page_objects.from_footer.PrivacyPolicy;

public class PrivacyPolicyTest extends JsaLoginBaseTestRunner {
    PrivacyPolicy privacyPolicy;
    @BeforeClass
    public void goPrivacyPolicy() {
        privacyPolicy = homeLoginModePO.goMainPage().goPrivacyPolicyFromFooter();
    }
    @Test(dataProvider = "getPrivacyPolicyLocators")
    public void privacyPolicyTest(OnixLocator locator) {
        onixAssert.checkCountOfElementByLocator(locator, 1);
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

