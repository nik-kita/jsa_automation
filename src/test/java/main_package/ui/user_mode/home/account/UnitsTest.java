package main_package.ui.user_mode.home.account;

import main_package.engine.OnixLocator;
import main_package.ui.user_mode.JsaLoginBaseTestRunner;
import main_package.ui.user_mode.general_parts.Footer;
import main_package.ui.user_mode.general_parts.home.account.AccountHeader;
import main_package.ui.user_mode.general_parts.home.account.AccountSidebar;
import main_package.ui.user_mode.page_objects.home_header.home.account.Units;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UnitsTest extends JsaLoginBaseTestRunner {
    @BeforeClass
    public void openUnitsPage() {
        homeLoginModePO.clickAccountIcon().clickUnits();
    }
    @Test(dataProvider = "origin")
    public void testUnitsPage(OnixLocator locator) {
        onixUiAssert.checkCountOfElementByLocator(locator, 1);
    }
    @DataProvider
    public Object[] origin() {
        return mergeArrays(
                Units.Locator.values(),
                AccountSidebar.AccountSidebarLocator.values(),
                Footer.FooterLocator.values(),
                AccountHeader.AccountHeaderLocator.values()
        );
    }
}
