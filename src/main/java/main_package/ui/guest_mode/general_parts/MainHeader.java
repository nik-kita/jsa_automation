package main_package.ui.guest_mode.general_parts;


import main_package.engine.test_engine.OnixUiAssert;
import org.openqa.selenium.By;
import main_package.ui.BasePart;
import main_package.engine.OnixLocator;
import main_package.engine.OnixWebDriver;
import main_package.ui.guest_mode.page_objects.main.*;
import main_package.ui.guest_mode.page_objects.main.login.CreateAccount;
import main_package.ui.guest_mode.page_objects.main.login.Login;
import main_package.ui.guest_mode.page_objects.main.my_podcast.MyPodcast;

public interface MainHeader extends BasePart {

    default Main clickHeaderJsaLogo() {
        OnixWebDriver driver = getDriver();
        driver.findElement(HeaderLocator.JSA_LOGO).click();
        getLogger().info("Click 'Jsa logo' button in header.");
        return new Main(driver);
    }
    default Main clickHeaderJsaLogo(OnixUiAssert onixUiAssert) {
        return clickHeaderJsaLogo().check(onixUiAssert);
    }

    default Challenge clickHeaderChallenge() {
        OnixWebDriver driver = getDriver();
        driver.findElement(HeaderLocator.CHALLENGE_HEADER_BUTTON).
                click();
        getLogger().info("Click 'Challenge' button in header.");
        return new Challenge(driver);
    }
    default Challenge clickHeaderChallenge(OnixUiAssert onixUiAssert) {
        return clickHeaderChallenge().check(onixUiAssert);
    }
    default Pricing clickHeaderPricing() {
        OnixWebDriver driver = getDriver();
        driver.findElement(HeaderLocator.PRICING_HEADER_BUTTON).
                click();
        getLogger().info("Click 'Pricing' button in header.");
        return new Pricing(driver);
    }
    default Pricing clickHeaderPricing(OnixUiAssert onixUiAssert) {
        return clickHeaderPricing().check(onixUiAssert);
    }
    default Transformations clickHeaderTransformations() {
        OnixWebDriver driver = getDriver();
        driver.findElement(HeaderLocator.TRANSFORMATIONS_HEADER_BUTTON).
                click();
        getLogger().info("Click 'Transformations' button in header.");
        return new Transformations(driver);
    }
    default Transformations clickHeaderTransformations(OnixUiAssert onixUiAssert) {
        return clickHeaderTransformations().check(onixUiAssert);
    }
    default Login clickHeaderLogin() {
        OnixWebDriver driver = getDriver();
        driver.findElement(HeaderLocator.LOGIN_HEADER_BUTTON).click();
        getLogger().info("Click 'Login' button in header.");
        return new Login(driver);
    }
    default Login clickHeaderLogin(OnixUiAssert onixUiAssert) {
       return clickHeaderLogin().check(onixUiAssert);
    }

    default CreateAccount clickHeaderJoinNow() {
        OnixWebDriver driver = getDriver();
        driver.findElement(HeaderLocator.JOIN_NOW_HEADER_BUTTON).click();
        getLogger().info("Click 'Join now' button in header.");
        return new CreateAccount(driver);
    }
    default CreateAccount clickHeaderJoinNow(OnixUiAssert onixUiAssert) {
        return clickHeaderJoinNow().check(onixUiAssert);
    }

    default MyPodcast clickHeaderMyPodcast() {
        OnixWebDriver driver = getDriver();
        driver.findElement(HeaderLocator.MY_PODCAST_HEADER_BUTTON).click();
        getLogger().info("Click 'My Podcast' button in header.");
        return new MyPodcast(driver);
    }
    default MyPodcast clickHeaderMyPodcast(OnixUiAssert onixUiAssert) {
        return clickHeaderMyPodcast().check(onixUiAssert);
    }

    enum HeaderLocator implements OnixLocator {
        JSA_LOGO(By.cssSelector("a[href='/'] img")),

        PRICING_HEADER_BUTTON(By.cssSelector(".nav a[href='/pricing/']")),
        TRANSFORMATIONS_HEADER_BUTTON(By.cssSelector(".nav a[href='/transformations/']")),
        CHALLENGE_HEADER_BUTTON(By.cssSelector(".nav a[href='/challenge/about/']")),
        MY_PODCAST_HEADER_BUTTON(By.cssSelector(".nav a[href='/podcasts/']")),
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
