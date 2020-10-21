package ui.guest_mode.general_parts;


import org.openqa.selenium.By;
import ui.BasePart;
import ui.engine.OnixLocator;
import ui.engine.OnixWebDriver;
import ui.guest_mode.page_objects.main.*;
import ui.guest_mode.page_objects.main.create_account.CreateAccount;
import ui.guest_mode.page_objects.main.login.Login;

public interface MainHeader extends BasePart {

    default Main goMainPage() {
        OnixWebDriver driver = getDriver();
        driver.findElement(HeaderLocator.JSA_LOGO).click();
        return new Main(driver);
    }
    default Challenge goChallengePage() {
        OnixWebDriver driver = getDriver();
        driver.findElement(HeaderLocator.CHALLENGE_HEADER_BUTTON).
                click();

        return new Challenge(driver);
    }
    default Pricing goPricingPage() {
        OnixWebDriver driver = getDriver();
        driver.findElement(HeaderLocator.PRICING_HEADER_BUTTON).
                click();
        return new Pricing(driver);
    }
    default Transformations goTransformationsPage() {
        OnixWebDriver driver = getDriver();
        driver.findElement(HeaderLocator.TRANSFORMATIONS_HEADER_BUTTON).
                click();
        return new Transformations(driver);
    }
    default Login goLoginPage() {
        OnixWebDriver driver = getDriver();
        driver.findElement(HeaderLocator.LOGIN_HEADER_BUTTON).click();
        return new Login(driver);
    }

    default CreateAccount goJoinNowPage() {
        OnixWebDriver driver = getDriver();
        driver.findElement(HeaderLocator.JOIN_NOW_HEADER_BUTTON).click();
        return new CreateAccount(driver);
    }

    enum HeaderLocator implements OnixLocator {
        JSA_LOGO(By.cssSelector("a[href='/'] img")),

        PRICING_HEADER_BUTTON(By.cssSelector(".nav a[href='/pricing/']")),
        TRANSFORMATIONS_HEADER_BUTTON(By.cssSelector(".nav a[href='/transformations/']")),
        CHALLENGE_HEADER_BUTTON(By.cssSelector(".nav a[href='/challenge/about/']")),
        LOGIN_HEADER_BUTTON(By.cssSelector(".nav a[href='/users/login/']")),
        JOIN_NOW_HEADER_BUTTON(By.cssSelector(".nav a[href='/users/register/']")),



        ;

        private By path;

        HeaderLocator(By path) {
            this.path = path;
        }

        @Override
        public By getPath() {
            return path;
        }
    }

}
