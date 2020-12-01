package test_package.automation;

import org.testng.annotations.Test;
import main_package.engine.test_engine.OnixTestRunner;
import main_package.ui.data.User;
import main_package.ui.user_mode.general_parts.home.HomeHeaderPart;

public class LoginTest extends OnixTestRunner {

    @Test
    public void loginWithFBTest() {
        openSite().goLoginPage().loginByFB(User.getValidUser());
        onixUiAssert.checkCountOfElementByLocator(HomeHeaderPart.HomeHeaderLocator.HOME, 1);
    }
}
