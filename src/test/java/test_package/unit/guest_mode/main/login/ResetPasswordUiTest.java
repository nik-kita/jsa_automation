package test_package.unit.guest_mode.main.login;


import main_package.engine.test_engine.OnixUiTestRunner;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.engine.OnixLocator;
import main_package.ui.___G_U_E_S_T___.page_objects.main.login.ResetPassword;

public class ResetPasswordUiTest extends OnixUiTestRunner {
    ResetPassword resetPasswordPO;
    @BeforeClass
    public void goResetPasswordPage() {
        resetPasswordPO = openSite().clickHeaderLogin().clickForgotPassword();
    }

    @Test(dataProvider = "getResetPasswordLocators")
    public void resetPasswordPageTest(OnixLocator locator) {
        onixUiAssert.checkCountOfElementByLocator(locator, 1);
    }
    @DataProvider
    public Object[] getResetPasswordLocators() {
        return mergeArrays(
                ResetPassword.FooterLocator.values(),
                ResetPassword.HeaderLocator.values(),
                ResetPassword.Locator.values()
        );
    }
}
