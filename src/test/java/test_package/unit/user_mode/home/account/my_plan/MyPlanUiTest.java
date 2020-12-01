package test_package.unit.user_mode.home.account.my_plan;

import main_package.engine.OnixLocator;
import main_package.ui.user_mode.JsaLoginBaseUiTestRunner;
import main_package.ui.user_mode.general_parts.Footer;
import main_package.ui.user_mode.general_parts.home.account.AccountHeader;
import main_package.ui.user_mode.general_parts.home.account.AccountSidebar;
import main_package.ui.user_mode.page_objects.home_header.home.account.my_plan.MyPlan;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MyPlanUiTest extends JsaLoginBaseUiTestRunner {
    @BeforeClass
    public void openAccount() {
        homeLoginModePO.clickAccountIcon();
    }
    @Test(dataProvider = "origin")
    public void accountPageTest(OnixLocator locator) {
        onixUiAssert.checkCountOfElementByLocator(locator, 1);
    }
    @DataProvider
    public Object[] origin() {
        return mergeArrays(
                MyPlan.Locator.values(),
                AccountHeader.AccountHeaderLocator.values(),
                AccountSidebar.AccountSidebarLocator.values(),
                Footer.FooterLocator.values()
        );
    }
}
