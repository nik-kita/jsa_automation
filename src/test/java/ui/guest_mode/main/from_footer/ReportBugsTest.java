package ui.guest_mode.main.from_footer;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ui.OnixAssert;
import ui.OnixTestRunner;
import ui.engine.OnixLocator;
import ui.guest_mode.page_objects.from_footer.ReportBugs;

public class ReportBugsTest extends OnixTestRunner {
    ReportBugs reportBugs;
    @BeforeClass
    public void goReportBugs() {
        reportBugs = openSite().goReportBugsFromFooter();
    }
    @Test(dataProvider = "getReportBugsLocators")
    public void reportBugsTest(OnixLocator locator) {
        onixAssert.checkCountOfElementByLocator(locator, 1);
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
