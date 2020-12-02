package test_package.unit.user_mode;


import org.testng.annotations.BeforeClass;
import main_package.engine.test_engine.OnixUiTestRunner;
import main_package.ui.shortcuts.RouteHacks;
import main_package.ui.user_mode.page_objects.home_header.home.Home;

public abstract class JsaLoginBaseUiTestRunner extends OnixUiTestRunner {
    public Home homeLoginModePO;

    @BeforeClass
    public void loginWelcome() {
        openSite();
        homeLoginModePO = new RouteHacks(driver).login();
    }
}
