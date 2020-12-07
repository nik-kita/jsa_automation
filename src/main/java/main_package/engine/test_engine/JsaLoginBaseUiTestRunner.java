package main_package.engine.test_engine;


import org.testng.annotations.BeforeClass;
import main_package.ui.shortcuts.RouteHacks;
import main_package.ui.___U_S_E_R___.page_objects.home_header.home.Home;

public abstract class JsaLoginBaseUiTestRunner extends OnixUiTestRunner {
    public Home homeLoginModePO;

    @BeforeClass
    public void loginWelcome() {
        openSite();
        homeLoginModePO = new RouteHacks(driver).login();
    }
}
