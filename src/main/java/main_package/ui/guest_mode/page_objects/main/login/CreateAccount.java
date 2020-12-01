package main_package.ui.guest_mode.page_objects.main.login;


import main_package.engine.test_engine.FlyTester;
import main_package.engine.test_engine.OnixUiAssert;
import org.openqa.selenium.By;
import main_package.ui.BasePageObject;
import main_package.engine.OnixLocator;
import main_package.engine.OnixWebDriver;
import main_package.ui.guest_mode.page_objects.from_footer.TermsOfService;
import main_package.ui.guest_mode.page_objects.main.Main;

public class CreateAccount extends BasePageObject {

    public CreateAccount(OnixWebDriver driver) {
        super(driver);
        logger.info("'Create Account' page is open.");
    }

    public CreateAccount check(OnixUiAssert onixUiAssert) {
        for(OnixLocator l : OnixUiAssert.mergeArrays(
                CreateAccount.Locator.values()
        )) {
            onixUiAssert.softCheckCountOfElementByLocator(l, 1);
        }
        return this;
    }

    @Override
    public CreateAccount test(FlyTester flyTester) {
        flyTester.test();
        return this;
    }

    public Main goMainPage() {
        driver.findElement(Locator.JSA_LOGO).click();
        logger.debug("go 'Main' from 'Create Account'");
        return new Main(driver);
    }

    public Login clickSignInButton() {
        driver.findElement(Locator.SIGN_IN_BUTTON).click();
        logger.debug("go 'Login' from 'Create Account'");
        return new Login(driver);
    }

    public TermsOfService clickTermsOfServiceLink() {
        driver.findElement(Locator.TERMS_OF_SERVICE_LINK).click();
        logger.debug("go 'Terms of Service' from 'Create Account'");
        return new TermsOfService(driver);
    }

    public enum Locator implements OnixLocator {
        JSA_LOGO(By.xpath("//a[@href='/']")),
        USERNAME_INPUT(By.xpath("//input[@name='username']")),
        EMAIL_INPUT(By.xpath("//input[@name='email']")),
        PASSWORD_INPUT(By.id("password")),
        PASSWORD_CONFIRMATION_INPUT(By.id("password2")),
        TERMS_CHECKBOX(By.xpath("//input[@name='terms']")),
        TERMS_OF_SERVICE_LINK(By.xpath("//a[@href='/terms/']")),
        PRIVACY_POLICY_LINK(By.xpath("//a[@href='/privacy/']")),
        CREATE_ACCOUNT_BUTTON(By.id("formButton")),
        FACEBOOK_BUTTON(By.cssSelector(".fb-button")),
        APPLE_BUTTON(By.cssSelector(".apple-button")),
        SIGN_IN_BUTTON(By.cssSelector("a[href='/users/login/']")),







        ;

        private By path;

        Locator(By path) {
            this.path = path;
        }
        @Override
        public By getPath() {
            return path;
        }

    }
}
