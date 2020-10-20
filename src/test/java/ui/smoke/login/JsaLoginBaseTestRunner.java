package ui.smoke.login;


import org.testng.annotations.BeforeClass;
import ui.OnixTestRunner;
import ui.shortcuts.RouteHacks;
import ui.user_mode.page_objects.home.Home;

public abstract class JsaLoginBaseTestRunner extends OnixTestRunner {
    Home homeLoginModePO;

    @BeforeClass
    public void loginWelcome() {
        openSite();
        homeLoginModePO = new RouteHacks(driver).login();
    }
}
