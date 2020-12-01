package main_package.ui.guest_mode.main.from_footer;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.engine.test_engine.OnixTestRunner;
import main_package.engine.OnixLocator;
import main_package.ui.guest_mode.page_objects.from_footer.CookiesPolicy;

public class CookiesPolicyTest extends OnixTestRunner {
    CookiesPolicy cookiesPolicy;
    @BeforeClass
    public void goCookiesPolicy() {
        cookiesPolicy = openSite().goCookiesPolicyFromFooter();
    }
    @Test(dataProvider = "getCookiesPolicyLocators")
    public void cookiesPolicyTest(OnixLocator locator) {
        onixUiAssert.checkCountOfElementByLocator(locator, 1);
    }
    @DataProvider
    public Object[] getCookiesPolicyLocators() {
        return mergeArrays(
                CookiesPolicy.FooterLocator.values(),
                CookiesPolicy.HeaderLocator.values(),
                CookiesPolicy.Locator.values()
        );
    }
}
