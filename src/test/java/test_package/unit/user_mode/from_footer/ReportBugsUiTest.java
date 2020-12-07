package test_package.unit.user_mode.from_footer;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.engine.OnixLocator;
import main_package.ui.___U_S_E_R___.page_objects.from_footer.ReportBugs;
import main_package.engine.test_engine.JsaLoginBaseUiTestRunner;

public class ReportBugsUiTest extends JsaLoginBaseUiTestRunner {
    ReportBugs reportBugs;
    @BeforeClass
    public void goReportBugs() {
        reportBugs = homeLoginModePO.goMainPage().goReportBugsFromFooter();
    }
    @Test(dataProvider = "getReportBugsLocators")
    public void reportBugsTest(OnixLocator locator) {
        onixUiAssert.checkCountOfElementByLocator(locator, 1);
    }
    @DataProvider
    public Object[] getReportBugsLocators() {
        return mergeArrays(
                ReportBugs.FooterLocator.values(),
                ReportBugs.HeaderLocator.values(),
                ReportBugs.Locator.values()
        );
    }
}
