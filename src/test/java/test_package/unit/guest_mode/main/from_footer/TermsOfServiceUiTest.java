package test_package.unit.guest_mode.main.from_footer;

import main_package.engine.test_engine.OnixUiTestRunner;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.engine.OnixLocator;
import main_package.ui.guest_mode.page_objects.from_footer.TermsOfService;

public class TermsOfServiceUiTest extends OnixUiTestRunner {
    TermsOfService termsOfService;
    @BeforeClass
    public void goTermsOfService() {
        termsOfService = openSite().clickFooterTermsOfService();
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
