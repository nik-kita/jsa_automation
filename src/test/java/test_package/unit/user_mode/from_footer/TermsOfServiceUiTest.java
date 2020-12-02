package test_package.unit.user_mode.from_footer;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.engine.OnixLocator;
import main_package.ui.user_mode.page_objects.from_footer.TermsOfService;
import main_package.ui.user_mode.JsaLoginBaseUiTestRunner;

public class TermsOfServiceUiTest extends JsaLoginBaseUiTestRunner {
    TermsOfService termsOfService;
    @BeforeClass
    public void goTermsOfService() {
        termsOfService = homeLoginModePO.goMainPage().goTermsOfServiceFromFooter();
    }
    @Test(dataProvider = "getTermsOfServiceLocators")
    public void termsOfServiceTest(OnixLocator locator) {
        onixUiAssert.checkCountOfElementByLocator(locator, 1);
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
