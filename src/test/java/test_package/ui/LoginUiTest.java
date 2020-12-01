package test_package.ui;

import main_package.engine.test_engine.OnixUiTestRunner;
import org.testng.annotations.Test;
import main_package.ui.data.User;
import main_package.ui.user_mode.general_parts.home.HomeHeaderPart;

public class LoginUiTest extends OnixUiTestRunner {

    @Test
    public void loginWithFBTest() {
        openSite().goLoginPage().loginByFB(User.getValidUser());
        onixUiAssert.checkCountOfElementByLocator(HomeHeaderPart.HomeHeaderLocator.HOME, 1);
    }
}
