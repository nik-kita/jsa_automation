package main_package.ui.user_mode.main;

import main_package.ui.user_mode.JsaLoginBaseUiTestRunner;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.engine.test_engine.OnixUiAssert;
import main_package.engine.OnixLocator;
import main_package.ui.user_mode.page_objects.main.FamousDailyEmails;

public class FamousDailyEmailsUiTest extends JsaLoginBaseUiTestRunner {
    FamousDailyEmails famousDailyEmails;
    @BeforeClass
    public void goFamousDailyEmails() {
        famousDailyEmails = homeLoginModePO.goMainPage().cheaterClickFamousDailyEmail();
    }
    @Test(dataProvider = "getFamousEmailsLocators")
    public void famousDailyEmailsTest(OnixLocator locator) {
        new OnixUiAssert(driver).checkCountOfElementByLocator(locator, 1);
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
