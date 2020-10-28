package ui.guest_mode.main.from_footer.faqs;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ui.OnixAssert;
import ui.OnixTestRunner;
import ui.engine.OnixLocator;
import ui.guest_mode.page_objects.from_footer.faqs.Faqs;

public class FaqsTest extends OnixTestRunner {
    Faqs faqs;
    @BeforeClass
    public void goFaqs() {
        faqs = openSite().goFaqsFromFooter();
    }
    @Test(dataProvider = "getFaqsLocators")
    public void faqsTest(OnixLocator locator) {
        onixAssert.checkCountOfElementByLocator(locator, 1);
    }
    @DataProvider
    public Object[] getFaqsLocators() {
        return mergeArrays(
                Faqs.FooterLocator.values(),
                Faqs.HeaderLocator.values(),
                Faqs.Locator.values()
        );
    }
}
