package automation;

import org.testng.annotations.Test;
import ui.OnixAssert;
import ui.OnixTestRunner;
import ui.data.User;
import ui.user_mode.general_parts.home.HomeHeaderPart;

public class LoginTest extends OnixTestRunner {

    @Test
    public void loginWithFBTest() {
        openSite().goLoginPage().loginByFB(User.getValidUser());
        new OnixAssert(driver).checkCountOfElementByLocator(HomeHeaderPart.HomeHeaderLocator.HOME, 1);
    }
}
