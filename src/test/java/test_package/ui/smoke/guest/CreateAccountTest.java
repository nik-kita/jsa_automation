package test_package.ui.smoke.guest;

import main_package.engine.test_engine.OnixUiTestRunner;
import main_package.ui.guest_mode.page_objects.main.login.CreateAccount;
import org.testng.annotations.*;
import org.uncommons.reportng.HTMLReporter;

@Listeners(HTMLReporter.class)
public class CreateAccountTest extends OnixUiTestRunner {
    CreateAccount createAccount;
    @BeforeMethod
    public void openCreateAccount() {
        createAccount = openSite().clickHeaderJoinNow();
    }
    @Test
    public void createAccountTest() {
        createAccount.check(onixUiAssert);
        onixUiAssert.assertAll();
    }
    @Test
    public void clickJsaLogoTest() {
        createAccount.clickJsaLogo().check(onixUiAssert);
        onixUiAssert.assertAll();
    }
    @Test
    public void clickSignInWithFacebook() {
        createAccount.clickSignInWithFacebook().check(onixUiAssert);
        onixUiAssert.assertAll();
    }
    @Test
    public void clickSignInWithApple() {
        //TODO after adding special AppleWindowForLogin class
        createAccount.clickSignInWithApple(onixUiAssert);
        onixUiAssert.assertAll();
    }
    @Test
    public void clickSignIn() {
        createAccount.clickSignInButton().check(onixUiAssert);
        onixUiAssert.assertAll();
    }
    @Test
    public void clickCreateAccountButton() {
        //TODO
    }
}
