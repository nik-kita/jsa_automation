package main_package.ui.guest_mode.general_parts;


import main_package.ui.engine.OnixAssert;
import org.openqa.selenium.By;
import main_package.ui.BasePart;
import main_package.ui.engine.OnixLocator;
import main_package.ui.engine.OnixWebDriver;
import main_package.ui.guest_mode.page_objects.main.*;
import main_package.ui.guest_mode.page_objects.main.login.CreateAccount;
import main_package.ui.guest_mode.page_objects.main.login.Login;
import main_package.ui.guest_mode.page_objects.main.my_podcast.MyPodcast;

public interface MainHeader extends BasePart {

    default Main goMainPage() {
        OnixWebDriver driver = getDriver();
        driver.findElement(HeaderLocator.JSA_LOGO).click();
        getLogger().debug("go 'Main' page by clicking 'JSA' logo on header");
        return new Main(driver);
    }
    default Challenge goChallengePage() {
        OnixWebDriver driver = getDriver();
        driver.findElement(HeaderLocator.CHALLENGE_HEADER_BUTTON).
                click();
        getLogger().debug("go to 'Challenge' page from header");
        return new Challenge(driver);
    }
    default Pricing goPricingPage() {
        OnixWebDriver driver = getDriver();
        driver.findElement(HeaderLocator.PRICING_HEADER_BUTTON).
                click();
        getLogger().debug("go to 'Pricing' page from header");
        return new Pricing(driver);
    }
    default Transformations goTransformationsPage() {
        OnixWebDriver driver = getDriver();
        driver.findElement(HeaderLocator.TRANSFORMATIONS_HEADER_BUTTON).
                click();
        getLogger().debug("go to 'Transformations' page from header");
        return new Transformations(driver);
    }
    default Login goLoginPage() {
        OnixWebDriver driver = getDriver();
        driver.findElement(HeaderLocator.LOGIN_HEADER_BUTTON).click();
        getLogger().debug("go 'Login' page from header");
        return new Login(driver);
    }
    default Login goLoginPage(OnixAssert onixAssert) {
        OnixWebDriver driver = getDriver();
        driver.findElement(HeaderLocator.LOGIN_HEADER_BUTTON).click();
        getLogger().debug("go 'Login' page from header");
        for(OnixLocator l : Login.Locator.values()) {
            onixAssert.softCheckCountOfElementByLocator(l, 1);
        }
        return new Login(driver);
    }

    default CreateAccount goCreateAccountPage() {
        OnixWebDriver driver = getDriver();
        driver.findElement(HeaderLocator.JOIN_NOW_HEADER_BUTTON).click();
        getLogger().debug("go 'Create Account' page from header");
        return new CreateAccount(driver);
    }
    default MyPodcast goMyPodcastPageFromHeader() {
        OnixWebDriver driver = getDriver();
        driver.findElement(HeaderLocator.MY_PODCAST_HEADER_BUTTON).click();
        getLogger().debug("go 'My Podcast' page from header");
        return new MyPodcast(driver);
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
