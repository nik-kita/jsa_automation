package main_package.ui.guest_mode.page_objects.main.login;


import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import main_package.ui.BasePageObject;
import main_package.ui.data.User;
import main_package.ui.engine.OnixLocator;
import main_package.ui.engine.OnixWebDriver;
import main_package.ui.engine.OnixWebElement;
import main_package.ui.guest_mode.page_objects.main.Main;
import main_package.ui.user_mode.page_objects.home_header.home.Home;

public class Login extends BasePageObject {


    public Login(OnixWebDriver driver) {
        super(driver);
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
        logger.debug("fo 'Home' from 'Login'");
        return new Home(driver);
    }

    public Home loginByFB(User user) {
        driver.findElement(Locator.FACEBOOK_BUTTON).click();
        return new FB(driver)
                .login(user.getFacebookEmail(), user.getFacebookPassword());
    }

    public CreateAccount clickCreateAccountButton() {
        driver.findElement(Locator.CREATE_ACCOUNT_LINK).click();
        logger.debug("go 'Create Account' from 'Login'");
        return new CreateAccount(driver);
    }

    private class FB {
        OnixWebDriver driver;
        Logger fbLogger;
        public FB(OnixWebDriver driver) {
            this.driver = driver;
            fbLogger = LoggerFactory.getLogger(this.getClass());
            fbLogger.debug("Facebook login page is opened");
        }
        OnixLocator emailOrNumberInput = makeOnixLocator(By.xpath("//input[@id='email']"), this.getClass());
        OnixLocator passwordInput = makeOnixLocator(By.xpath("//input[@type='password']"), this.getClass());
        OnixLocator enterButton = makeOnixLocator(By.cssSelector("#loginbutton"), this.getClass());
        OnixLocator confirmButton = makeOnixLocator(By.xpath("//button[@name='__CONFIRM__']"), this.getClass());

        public Home login(String name, String password) {
            driver.findElement(emailOrNumberInput).sendKeys(name);
            driver.findElement(passwordInput).sendKeys(password);
            driver.findElement(enterButton).click();
            if(driver.isElementPresent(confirmButton)) {
                fbLogger.debug("additional facebook page for confirmation is present");
                driver.waitToClick(confirmButton).click();
            }
            OnixLocator firstCheckNameInput = makeOnixLocator(By.xpath("//input[contains(@value, ' ')]"), Home.class);
            OnixLocator firstCheckTermsCheckbox = makeOnixLocator(By.cssSelector(".checkbox #terms-styler"), Home.class);
            OnixLocator firstCheckCreateAccountButton = makeOnixLocator(By.cssSelector("input[type='submit']"), Home.class);
            if(driver.isElementPresent(firstCheckNameInput)) {
                driver.waitToClick(firstCheckTermsCheckbox).click();
                driver.waitToClick(firstCheckCreateAccountButton).click();
                fbLogger.debug("additional first name checking page is present");
            }
            fbLogger.debug("'Home' from 'FB'");
            return new Home(driver);
        }
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
