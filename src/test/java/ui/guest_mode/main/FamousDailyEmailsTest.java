package ui.guest_mode.main;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ui.OnixAssert;
import ui.OnixTestRunner;
import ui.engine.OnixLocator;
import ui.guest_mode.general_parts.Footer;
import ui.guest_mode.general_parts.MainHeader;
import ui.guest_mode.page_objects.main.FamousDailyEmails;

public class FamousDailyEmailsTest extends OnixTestRunner {
    FamousDailyEmails famousDailyEmails;
    @BeforeClass
    public void goFamousDailyEmails() {
        famousDailyEmails = openSite().cheaterClickFamousDailyEmail();
    }
    @Test(dataProvider = "getFamousEmailsLocators")
    public void famousDailyEmailsTest(OnixLocator locator) {
        onixAssert.checkCountOfElementByLocator(locator, 1);
    }
    @DataProvider
    public Object[] getFamousEmailsLocators() {
        return mergeArrays(
                FamousDailyEmails.FooterLocator.values(),
                FamousDailyEmails.Locator.values(),
                FamousDailyEmails.HeaderLocator.values()
        );
    }
}
