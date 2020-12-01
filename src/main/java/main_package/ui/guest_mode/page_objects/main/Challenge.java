package main_package.ui.guest_mode.page_objects.main;


import main_package.engine.test_engine.FlyTester;
import org.openqa.selenium.By;
import main_package.ui.BasePageObject;
import main_package.engine.OnixLocator;
import main_package.engine.OnixWebDriver;
import main_package.ui.guest_mode.general_parts.Footer;
import main_package.ui.guest_mode.general_parts.MainHeader;
import main_package.ui.guest_mode.page_objects.main.login.CreateAccount;

public class Challenge extends BasePageObject implements Footer, MainHeader {
    public Challenge(OnixWebDriver driver) {
        super(driver);
    }
    @Override
    public Challenge test(FlyTester flyTester) {
        flyTester.test();
        return this;
    }
    public CreateAccount clickCreateAccountButton() {
        driver.findElement(Locator.CREATE_ACCOUNT_BUTTON_INNER_PAGE).click();
        logger.debug("'Create Account' from 'Challenge'");
        return new CreateAccount(driver);
    }


    public enum Locator implements OnixLocator {
        CREATE_ACCOUNT_BUTTON_INNER_PAGE(By.cssSelector(".inner_page a[href='/users/register/']")),
        EMAIL_INPUT_INNER_PAGE(By.cssSelector("input[name='email']")),
        SIGN_UP_BUTTON_INNER_PAGE(By.cssSelector("button[onclick='submitRegisterInterest()']")),
        PREMIUM_PLAN_LINK(By.cssSelector("[href='/users/pricing/']")),



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
