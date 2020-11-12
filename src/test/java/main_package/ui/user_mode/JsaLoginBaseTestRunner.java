package main_package.ui.user_mode;


import org.testng.annotations.BeforeClass;
import test_package.test_engine.OnixTestRunner;
import main_package.ui.shortcuts.RouteHacks;
import main_package.ui.user_mode.page_objects.home_header.home.Home;

public abstract class JsaLoginBaseTestRunner extends OnixTestRunner {
    public Home homeLoginModePO;

    @BeforeClass
    public void loginWelcome() {
        openSite();
        homeLoginModePO = new RouteHacks(driver).login();
    }
}
