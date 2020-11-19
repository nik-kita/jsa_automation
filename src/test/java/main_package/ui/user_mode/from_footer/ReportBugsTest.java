package main_package.ui.user_mode.from_footer;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.ui.engine.OnixLocator;
import main_package.ui.user_mode.JsaLoginBaseTestRunner;
import main_package.ui.user_mode.page_objects.from_footer.ReportBugs;

public class ReportBugsTest extends JsaLoginBaseTestRunner {
    ReportBugs reportBugs;
    @BeforeClass
    public void goReportBugs() {
        reportBugs = homeLoginModePO.goMainPage().goReportBugsFromFooter();
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