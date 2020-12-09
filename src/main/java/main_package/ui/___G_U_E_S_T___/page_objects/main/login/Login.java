package main_package.ui.___G_U_E_S_T___.page_objects.main.login;


import main_package.engine.*;
import main_package.engine.test_engine.FlyTester;
import main_package.engine.test_engine.OnixUiAssert;
import org.openqa.selenium.By;
import main_package.ui.BasePageObject;
import main_package.ui.data.User;
import main_package.ui.___G_U_E_S_T___.page_objects.main.Main;
import main_package.ui.___U_S_E_R___.page_objects.home_header.home.Home;

public class Login extends BasePageObject {


    public Login(OnixWebDriver driver) {
        super(driver);
        logger.debug("'Login' page is open.");
    }
    public Login check(OnixUiAssert onixUiAssert) {
        for(OnixLocator l : OnixUiAssert.mergeArrays(
                Login.Locator.values()
        )) {
            onixUiAssert.softCheckCountOfElementByLocator(l, 1);
        }
        return this;
    }

    @Override
    public Login test(FlyTester flyTester) {
        flyTester.test();
        return this;
    }

    public Main goHomePage() {
        driver.findElement(Locator.JSA_LOGO).click();
        logger.debug("go 'Main' from 'Login'");
        return new Main(driver);
    }

    private OnixWebElement getUserInput() {
        return driver.findElement(Locator.USERNAME_INPUT);
    }

    private OnixWebElement getPasswordInput() {
        return driver.findElement(Locator.PASSWORD_INPUT);
    }

    private OnixWebElement getSubmitButton() {
        return driver.findElement(Locator.GET_STARTED_BUTTON);
    }

    private void fillUserInput(String userNameOrEmail) {
        getUserInput().sendKeys(userNameOrEmail);
    }

    private void fillPasswordInput(String password) {
        getPasswordInput().sendKeys(password);
    }

    public Home login(User validUser) {
        fillUserInput(validUser.getName());
        fillPasswordInput(validUser.getPassword());
        getSubmitButton().click();
        logger.debug("Login to the site by valid user's credentials.");
        return new Home(driver);
    }
    public Home login(User validUser, OnixUiAssert onixUiAssert) {
        fillUserInput(validUser.getName());
        fillPasswordInput(validUser.getPassword());
        getSubmitButton().click();
        logger.info("Fill email and password inputs by valid user's credentials.");
        for(OnixLocator l : Home.Locator.values()) {
            onixUiAssert.softCheckCountOfElementByLocator(l, 1);
        }
        return new Home(driver);
    }

    public Home loginByFB(User user) {
        driver.findElement(Locator.FACEBOOK_BUTTON).click();
        return new FbWindowForLogin(driver)
                .login(user.getFacebookEmail(), user.getFacebookPassword());
    }

    public CreateAccount clickCreateAccountButton() {
        driver.findElement(Locator.CREATE_ACCOUNT_LINK).click();
        logger.debug("go 'Create Account' from 'Login'");
        return new CreateAccount(driver);
    }



    public ResetPassword clickForgotPassword() {
        driver.findElement(Locator.FORGOT_PASSWORD_LINK).click();
        logger.debug("'Reset Password' from 'Login'");
        return new ResetPassword(driver);
    }


    public enum Locator implements OnixLocator {
        JSA_LOGO(By.xpath("//a[@href='/']")),
        USERNAME_INPUT(By.xpath("//input[@name='username']")),
        PASSWORD_INPUT(By.id("password")),
        FORGOT_PASSWORD_LINK(By.xpath("//a[contains(text(), 'Forgot')]")),
        GET_STARTED_BUTTON(By.xpath("//button[contains(text(), 'Started')]")),
        FACEBOOK_BUTTON(By.cssSelector(".fb-button")),
        APPLE_BUTTON(By.cssSelector(".apple-button")),
        CREATE_ACCOUNT_LINK(By.xpath("//*[@href='/users/register/']"))

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
