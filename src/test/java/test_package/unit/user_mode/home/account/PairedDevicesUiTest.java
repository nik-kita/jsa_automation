package test_package.unit.user_mode.home.account;

import main_package.engine.OnixLocator;

import main_package.ui.user_mode.general_parts.Footer;
import main_package.ui.user_mode.general_parts.home.account.AccountHeader;
import main_package.ui.user_mode.general_parts.home.account.AccountSidebar;
import main_package.ui.user_mode.page_objects.home_header.home.account.PairedDevices;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.engine.test_engine.JsaLoginBaseUiTestRunner;

public class PairedDevicesUiTest extends JsaLoginBaseUiTestRunner {
    @BeforeClass
    public void openPairedDevicesPage() {
        homeLoginModePO.clickAccountIcon().clickPairedDevices();
    }
    @Test(dataProvider = "origin")
    public void pairedDevicesTest(OnixLocator locator) {
        onixUiAssert.checkCountOfElementByLocator(locator, 1);
    }
    @DataProvider
    public Object[] origin() {
        return mergeArrays(
                PairedDevices.Locator.values(),
                AccountSidebar.AccountSidebarLocator.values(),
                Footer.FooterLocator.values(),
                AccountHeader.AccountHeaderLocator.values()
        );
    }
}