package ui.user_mode.from_footer.faqs;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ui.OnixAssert;
import ui.OnixTestRunner;
import ui.engine.OnixLocator;
import ui.user_mode.page_objects.from_footer.faqs.Faqs;
import ui.user_mode.JsaLoginBaseTestRunner;

public class FaqsTest extends JsaLoginBaseTestRunner {
    Faqs faqs;
    @BeforeClass
    public void goFaqs() {
        faqs = homeLoginModePO.goMainPage().goFaqsFromFooter();
    }
    @Test(dataProvider = "getFaqsLocators")
    public void faqsTest(OnixLocator locator) {
        new OnixAssert(driver).checkCountOfElementByLocator(locator, 1);
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
