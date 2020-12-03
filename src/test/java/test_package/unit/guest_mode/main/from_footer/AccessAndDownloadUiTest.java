package test_package.unit.guest_mode.main.from_footer;

import main_package.engine.test_engine.OnixUiTestRunner;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.engine.OnixLocator;
import main_package.ui.guest_mode.page_objects.from_footer.AccessAndDownload;


public class AccessAndDownloadUiTest extends OnixUiTestRunner {
    AccessAndDownload accessAndDownload;
    @BeforeClass
    public void goAccessAndDownload() {
        accessAndDownload = openSite().clickFooterAccess();
    }
    @Test(dataProvider = "getAccessAndDownloadLocators")
    public void accessAndDownloadTest(OnixLocator locator) {
        onixUiAssert.checkCountOfElementByLocator(locator, 1);
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
