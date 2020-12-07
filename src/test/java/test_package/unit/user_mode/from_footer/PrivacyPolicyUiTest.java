package test_package.unit.user_mode.from_footer;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.engine.OnixLocator;
import main_package.ui.___U_S_E_R___.page_objects.from_footer.PrivacyPolicy;
import main_package.engine.test_engine.JsaLoginBaseUiTestRunner;

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

