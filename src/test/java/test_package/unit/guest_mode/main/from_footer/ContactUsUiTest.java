package test_package.unit.guest_mode.main.from_footer;

import main_package.engine.test_engine.OnixUiTestRunner;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.engine.OnixLocator;
import main_package.ui.guest_mode.page_objects.from_footer.ContactUs;

public class ContactUsUiTest extends OnixUiTestRunner {
    ContactUs contactUs;
    @BeforeClass
    public void goContactUs() {
        contactUs = openSite().goContactUsFromFooter();
    }
    @Test(dataProvider = "getContactUsLocators")
    public void contactUsTest(OnixLocator locator) {
        onixUiAssert.checkCountOfElementByLocator(locator, 1);
    }
    @DataProvider
    public Object[] getContactUsLocators() {
        return mergeArrays(
                ContactUs.FooterLocator.values(),
                ContactUs.HeaderLocator.values(),
                ContactUs.Locator.values()
        );
    }
}
