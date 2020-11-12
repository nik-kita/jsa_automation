package main_package.ui.user_mode.from_footer.faqs;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.ui.engine.OnixLocator;
import main_package.ui.user_mode.page_objects.from_footer.faqs.Faqs;
import main_package.ui.user_mode.JsaLoginBaseTestRunner;

public class FaqsTest extends JsaLoginBaseTestRunner {
    Faqs faqs;
    @BeforeClass
    public void goFaqs() {
        faqs = homeLoginModePO.goMainPage().goFaqsFromFooter();
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
