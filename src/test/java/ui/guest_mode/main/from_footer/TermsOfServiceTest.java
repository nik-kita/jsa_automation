package ui.guest_mode.main.from_footer;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ui.OnixAssert;
import ui.OnixTestRunner;
import ui.engine.OnixLocator;
import ui.guest_mode.page_objects.from_footer.TermsOfService;

public class TermsOfServiceTest extends OnixTestRunner {
    TermsOfService termsOfService;
    @BeforeClass
    public void goTermsOfService() {
        termsOfService = openSite().goTermsOfServiceFromFooter();
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
