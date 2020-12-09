package test_package.unit.guest_mode.main.from_footer;

import main_package.engine.test_engine.OnixUiTestRunner;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.engine.OnixLocator;
import main_package.ui.___G_U_E_S_T___.page_objects.from_footer.ReportBugs;

public class ReportBugsUiTest extends OnixUiTestRunner {
    ReportBugs reportBugs;
    @BeforeClass
    public void goReportBugs() {
        reportBugs = openSite().clickFooterBugReports();
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
