package test_package.unit.user_mode.from_footer;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.engine.OnixLocator;
import main_package.ui.___U_S_E_R___.page_objects.from_footer.AccessAndDownload;
import main_package.engine.test_engine.JsaLoginBaseUiTestRunner;


public class AccessAndDownloadUiTest extends JsaLoginBaseUiTestRunner {
    AccessAndDownload accessAndDownload;
    @BeforeClass
    public void goAccessAndDownload() {
        accessAndDownload = homeLoginModePO.goMainPage().goAccessAndDownloadFromFooter();
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
