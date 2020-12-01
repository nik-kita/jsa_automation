package main_package.ui.user_mode.from_footer.faqs;

import main_package.ui.user_mode.JsaLoginBaseUiTestRunner;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.engine.OnixLocator;
import main_package.ui.user_mode.page_objects.from_footer.faqs.Faqs;

public class FaqsUiTest extends JsaLoginBaseUiTestRunner {
    Faqs faqs;
    @BeforeClass
    public void goFaqs() {
        faqs = homeLoginModePO.goMainPage().goFaqsFromFooter();
    }
    @Test(dataProvider = "getFaqsLocators")
    public void faqsTest(OnixLocator locator) {
        onixUiAssert.checkCountOfElementByLocator(locator, 1);
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
