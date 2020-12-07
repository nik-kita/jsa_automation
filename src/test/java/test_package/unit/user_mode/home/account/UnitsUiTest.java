package test_package.unit.user_mode.home.account;

import main_package.engine.OnixLocator;

import main_package.ui.___U_S_E_R___.general_parts.Footer;
import main_package.ui.___U_S_E_R___.general_parts.home.account.AccountHeader;
import main_package.ui.___U_S_E_R___.general_parts.home.account.AccountSidebar;
import main_package.ui.___U_S_E_R___.page_objects.home_header.home.account.Units;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.engine.test_engine.JsaLoginBaseUiTestRunner;

public class UnitsUiTest extends JsaLoginBaseUiTestRunner {
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
