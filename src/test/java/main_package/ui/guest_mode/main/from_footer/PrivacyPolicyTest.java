package main_package.ui.guest_mode.main.from_footer;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test_package.test_engine.OnixTestRunner;
import main_package.ui.engine.OnixLocator;
import main_package.ui.guest_mode.page_objects.from_footer.PrivacyPolicy;

public class PrivacyPolicyTest extends OnixTestRunner {
    PrivacyPolicy privacyPolicy;
    @BeforeClass
    public void goPrivacyPolicy() {
        privacyPolicy = openSite().goPrivacyPolicyFromFooter();
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

