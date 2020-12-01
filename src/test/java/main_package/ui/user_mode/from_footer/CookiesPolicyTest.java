package main_package.ui.user_mode.from_footer;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.engine.OnixLocator;
import main_package.ui.user_mode.page_objects.from_footer.CookiesPolicy;
import main_package.ui.user_mode.JsaLoginBaseTestRunner;

public class CookiesPolicyTest extends JsaLoginBaseTestRunner {
    CookiesPolicy cookiesPolicy;
    @BeforeClass
    public void goCookiesPolicy() {
        cookiesPolicy = homeLoginModePO.goMainPage().goCookiesPolicyFromFooter();
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
