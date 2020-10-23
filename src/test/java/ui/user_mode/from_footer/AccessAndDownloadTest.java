package ui.user_mode.from_footer;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ui.OnixAssert;
import ui.engine.OnixLocator;
import ui.user_mode.JsaLoginBaseTestRunner;
import ui.user_mode.page_objects.from_footer.AccessAndDownload;


public class AccessAndDownloadTest extends JsaLoginBaseTestRunner {
    AccessAndDownload accessAndDownload;
    @BeforeClass
    public void goAccessAndDownload() {
        accessAndDownload = homeLoginModePO.goMainPage().goAccessAndDownloadFromFooter();
    }
    @Test(dataProvider = "getAccessAndDownloadLocators")
    public void accessAndDownloadTest(OnixLocator locator) {
        new OnixAssert(driver).checkCountOfElementByLocator(locator, 1);
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