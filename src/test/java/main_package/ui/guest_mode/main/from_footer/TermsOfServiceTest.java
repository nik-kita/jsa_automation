package main_package.ui.guest_mode.main.from_footer;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.engine.test_engine.OnixTestRunner;
import main_package.engine.OnixLocator;
import main_package.ui.guest_mode.page_objects.from_footer.TermsOfService;

public class TermsOfServiceTest extends OnixTestRunner {
    TermsOfService termsOfService;
    @BeforeClass
    public void goTermsOfService() {
        termsOfService = openSite().goTermsOfServiceFromFooter();
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
