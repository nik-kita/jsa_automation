package ui.functionality;

import org.testng.annotations.Test;
import ui.OnixAssert;
import ui.OnixTestRunner;
import ui.data.User;
import ui.user_mode.general_parts.HomeHeader;

public class LoginTest extends OnixTestRunner {

    @Test
    public void loginWithFBTest() {
        openSite().goLoginPage().loginByFB(User.getValidUser());
        new OnixAssert(driver).checkCountOfElementByLocator(HomeHeader.HeaderLocator.HOME, 1);
    }
}
