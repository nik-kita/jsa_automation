package main_package.ui.guest_mode.main.from_footer;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.engine.test_engine.OnixTestRunner;
import main_package.engine.OnixLocator;
import main_package.ui.guest_mode.page_objects.from_footer.ReportBugs;

public class ReportBugsTest extends OnixTestRunner {
    ReportBugs reportBugs;
    @BeforeClass
    public void goReportBugs() {
        reportBugs = openSite().goReportBugsFromFooter();
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
