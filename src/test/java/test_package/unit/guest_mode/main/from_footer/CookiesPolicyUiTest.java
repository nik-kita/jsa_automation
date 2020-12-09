package test_package.unit.guest_mode.main.from_footer;

import main_package.engine.test_engine.OnixUiTestRunner;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.engine.OnixLocator;
import main_package.ui.___G_U_E_S_T___.page_objects.from_footer.CookiesPolicy;

public class CookiesPolicyUiTest extends OnixUiTestRunner {
    CookiesPolicy cookiesPolicy;
    @BeforeClass
    public void goCookiesPolicy() {
        cookiesPolicy = openSite().clickFooterCookiesPolicy();
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
