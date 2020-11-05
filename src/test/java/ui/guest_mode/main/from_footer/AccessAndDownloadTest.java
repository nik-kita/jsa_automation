package ui.guest_mode.main.from_footer;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test_engine.OnixTestRunner;
import ui.engine.OnixLocator;
import ui.guest_mode.page_objects.from_footer.AccessAndDownload;


public class AccessAndDownloadTest extends OnixTestRunner {
    AccessAndDownload accessAndDownload;
    @BeforeClass
    public void goAccessAndDownload() {
        accessAndDownload = openSite().goAccessAndDownloadFromFooter();
    }
    @Test(dataProvider = "getAccessAndDownloadLocators")
    public void accessAndDownloadTest(OnixLocator locator) {
        onixAssert.checkCountOfElementByLocator(locator, 1);
    }
    @DataProvider
    public Object[] getAccessAndDownloadLocators() {
        return mergeArrays(
                AccessAndDownload.FooterLocator.values(),
                AccessAndDownload.HeaderLocator.values(),
                AccessAndDownload.Locator.values()
        );
    }
}
