package main_package.ui.guest_mode.main;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.engine.test_engine.OnixUiTestRunner;
import main_package.engine.OnixLocator;
import main_package.ui.guest_mode.page_objects.main.FamousDailyEmails;

public class FamousDailyEmailsUiTest extends OnixUiTestRunner {
    FamousDailyEmails famousDailyEmails;
    @BeforeClass
    public void goFamousDailyEmails() {
        famousDailyEmails = openSite().cheaterClickFamousDailyEmail();
    }
    @Test(dataProvider = "getFamousEmailsLocators")
    public void famousDailyEmailsTest(OnixLocator locator) {
        onixUiAssert.checkCountOfElementByLocator(locator, 1);
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
