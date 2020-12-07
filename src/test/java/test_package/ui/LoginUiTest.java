package test_package.ui;

import main_package.engine.test_engine.OnixUiTestRunner;
import org.testng.annotations.Test;
import main_package.ui.data.User;
import main_package.ui.___U_S_E_R___.general_parts.home.HomeHeaderPart;

public class LoginUiTest extends OnixUiTestRunner {

    @Test
    public void loginWithFBTest() {
        openSite().clickHeaderLogin().loginByFB(User.getValidUser());
        onixUiAssert.checkCountOfElementByLocator(HomeHeaderPart.HomeHeaderLocator.HOME, 1);
    }
}
