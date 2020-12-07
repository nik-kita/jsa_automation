package test_package.unit.user_mode.main;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.engine.test_engine.OnixUiAssert;
import main_package.engine.OnixLocator;
import main_package.ui.___U_S_E_R___.page_objects.main.FamousDailyEmails;
import main_package.engine.test_engine.JsaLoginBaseUiTestRunner;

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
