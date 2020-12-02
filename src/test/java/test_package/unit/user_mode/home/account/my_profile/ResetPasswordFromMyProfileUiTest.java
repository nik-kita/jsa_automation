package test_package.unit.user_mode.home.account.my_profile;

import main_package.engine.OnixLocator;
import main_package.ui.user_mode.general_parts.Footer;
import main_package.ui.user_mode.general_parts.home.account.AccountHeader;
import main_package.ui.user_mode.page_objects.home_header.home.account.my_profile.ResetPasswordFromMyProfile;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.engine.test_engine.JsaLoginBaseUiTestRunner;

public class ResetPasswordFromMyProfileUiTest extends JsaLoginBaseUiTestRunner {
    @BeforeClass
    public void openResetPasswordPage() {
        homeLoginModePO.clickAccountIcon().clickMyProfile().clickResetPassword();
    }
    @Test(dataProvider = "origin")
    public void resetPasswordPageTest(OnixLocator locator) {
        onixUiAssert.checkCountOfElementByLocator(locator, 1);
    }
    @DataProvider
    public Object[] origin() {
        return mergeArrays(
                ResetPasswordFromMyProfile.Locator.values(),
                AccountHeader.AccountHeaderLocator.values(),
                Footer.FooterLocator.values()
        );
    }
}
