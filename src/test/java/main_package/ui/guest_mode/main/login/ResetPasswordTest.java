package main_package.ui.guest_mode.main.login;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test_package.test_engine.OnixTestRunner;
import main_package.ui.engine.OnixLocator;
import main_package.ui.guest_mode.page_objects.main.login.ResetPassword;

public class ResetPasswordTest extends OnixTestRunner {
    ResetPassword resetPasswordPO;
    @BeforeClass
    public void goResetPasswordPage() {
        resetPasswordPO = openSite().goLoginPage().clickForgotPassword();
    }

    @Test(dataProvider = "getResetPasswordLocators")
    public void resetPasswordPageTest(OnixLocator locator) {
        onixAssert.checkCountOfElementByLocator(locator, 1);
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