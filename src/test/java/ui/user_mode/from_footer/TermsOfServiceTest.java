package ui.user_mode.from_footer;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ui.OnixAssert;
import ui.engine.OnixLocator;
import ui.user_mode.page_objects.from_footer.TermsOfService;
import ui.user_mode.JsaLoginBaseTestRunner;

public class TermsOfServiceTest extends JsaLoginBaseTestRunner {
    TermsOfService termsOfService;
    @BeforeClass
    public void goTermsOfService() {
        termsOfService = homeLoginModePO.goMainPage().goTermsOfServiceFromFooter();
    }
    @Test(dataProvider = "getTermsOfServiceLocators")
    public void termsOfServiceTest(OnixLocator locator) {
        new OnixAssert(driver).checkCountOfElementByLocator(locator, 1);
    }
    @DataProvider
    public Object[] getTermsOfServiceLocators() {
        return mergeArrays(
                TermsOfService.FooterLocator.values(),
                TermsOfService.HeaderLocator.values(),
                TermsOfService.Locator.values()
        );
    }
}
