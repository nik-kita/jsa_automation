package ui.user_mode.from_footer;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ui.OnixAssert;
import ui.engine.OnixLocator;
import ui.user_mode.JsaLoginBaseTestRunner;
import ui.user_mode.page_objects.from_footer.ContactUs;

public class ContactUsTest extends JsaLoginBaseTestRunner {
    ContactUs contactUs;
    @BeforeClass
    public void goContactUs() {
        contactUs = homeLoginModePO.goMainPage().goContactUsFromFooter();
    }
    @Test(dataProvider = "getContactUsLocators")
    public void contactUsTest(OnixLocator locator) {
        new OnixAssert(driver).checkCountOfElementByLocator(locator, 1);
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
