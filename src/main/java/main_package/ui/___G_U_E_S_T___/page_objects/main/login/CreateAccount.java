package main_package.ui.___G_U_E_S_T___.page_objects.main.login;


import main_package.engine.test_engine.FlyTester;
import main_package.engine.test_engine.OnixUiAssert;
import main_package.ui.related_sites.InCurrentTab;
import org.openqa.selenium.By;
import main_package.ui.BasePageObject;
import main_package.engine.OnixLocator;
import main_package.engine.OnixWebDriver;
import main_package.ui.___G_U_E_S_T___.page_objects.from_footer.TermsOfService;
import main_package.ui.___G_U_E_S_T___.page_objects.main.Main;
import org.slf4j.Logger;

public class CreateAccount extends BasePageObject {

    public CreateAccount(OnixWebDriver driver) {
        super(driver);
        logger.debug("'Create Account' page is open.");
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

    public Main clickJsaLogo() {
        driver.findElement(Locator.JSA_LOGO).click();
        logger.info("Click 'JSA' logo.");
        return new Main(driver);
    }
    public Main clickJsaLogo(OnixUiAssert onixUiAssert){
        return clickJsaLogo().check(onixUiAssert);
    }

    public Login clickSignInButton() {
        driver.findElement(Locator.SIGN_IN_BUTTON).click();
        logger.info("Click 'Sign In' button.");
        return new Login(driver);
    }


    public TermsOfService clickTermsOfServiceLink() {
        driver.findElement(Locator.TERMS_OF_SERVICE_LINK).click();
        logger.info("Click 'Terms of service' checkbox.");
        return new TermsOfService(driver);
    }

    public FbWindowForLogin clickSignInWithFacebook() {
        driver.findElement(Locator.FACEBOOK_BUTTON).click();
        logger.info("Click 'Sign in with Facebook' button.");
        return new FbWindowForLogin(driver);
    }


    public InCurrentTab clickSignInWithApple() {
        driver.findElement(Locator.APPLE_BUTTON).click();
        logger.warn("Click 'Sign in with Apple' button. But this page in //TODO for testFramework!");
        return new InCurrentTab() {
            //TODO Make normal class for AppleWindowForLogin
            @Override
            public Logger getLogger() {
                return logger;
            }

            @Override
            public OnixWebDriver getDriver() {
                return driver;
            }

        };
    }
    public InCurrentTab clickSignInWithApple(OnixUiAssert onixUiAssert) {
        driver.findElement(Locator.APPLE_BUTTON).click();
        logger.warn("Click 'Sign in with Apple' button. But this page in //TODO for testFramework!");
        return new InCurrentTab() {
            //TODO Make normal class for AppleWindowForLogin
            @Override
            public Logger getLogger() {
                return logger;
            }

            @Override
            public OnixWebDriver getDriver() {
                return driver;
            }

            {
                onixUiAssert.softCheckUrlContains("apple");
            }

        };
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
