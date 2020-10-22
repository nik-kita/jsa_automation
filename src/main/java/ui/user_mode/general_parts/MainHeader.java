package ui.user_mode.general_parts;

import ui.engine.OnixLocator;
import org.openqa.selenium.By;
import ui.BasePart;
import ui.engine.OnixWebDriver;
import ui.user_mode.page_objects.main.Challenge;
import ui.user_mode.page_objects.main.Transformations;
import ui.user_mode.page_objects.main.my_podcast.MyPodcast;
import ui.user_mode.general_parts.home.HomeHeaderPart;
import ui.user_mode.page_objects.main.Main;
import ui.user_mode.page_objects.main.pricing.Pricing;

public interface MainHeader extends BasePart {

    default Main goMainPage() {
        OnixWebDriver driver = getDriver();
        driver.findElement(HomeHeaderPart.HomeHeaderLocator.JSA_LOGO).click();
        return new Main(driver);
    }
    default Pricing goPricingPage() {
        OnixWebDriver driver = getDriver();
        driver.findElement(HeaderLocator.PRICING_HEADER_BUTTON).click();
        return new Pricing(driver);
    }
    default Challenge goChallengePage() {
        OnixWebDriver driver = getDriver();
        driver.findElement(ui.guest_mode.general_parts.MainHeader.HeaderLocator.CHALLENGE_HEADER_BUTTON).
                click();

        return new Challenge(driver);
    }
    default Transformations goTransformationsPage() {
        OnixWebDriver driver = getDriver();
        driver.findElement(ui.guest_mode.general_parts.MainHeader.HeaderLocator.TRANSFORMATIONS_HEADER_BUTTON).
                click();
        return new Transformations(driver);
    }
    default MyPodcast goMyPodcastPageFromHeader() {
        OnixWebDriver driver = getDriver();
        driver.findElement(ui.guest_mode.general_parts.MainHeader.HeaderLocator.MY_PODCAST_HEADER_BUTTON).click();
        return new MyPodcast(driver);
    }

    enum HeaderLocator implements OnixLocator {
        JSA_LOGO(By.cssSelector("a[href='/'] img")),
        BOOK_LOGO(By.cssSelector(".nav a[href='/not-a-diet-book/'] img")),//TODO there are two books logos on this locator
        PRICING_HEADER_BUTTON(By.cssSelector(".nav a[href='/pricing/']")),
        TRANSFORMATIONS_HEADER_BUTTON(By.cssSelector(".nav a[href='/transformations/']")),
        CHALLENGE_HEADER_BUTTON(By.cssSelector(".nav a[href='/challenge/about/']")),
        MY_PODCAST_HEADER_BUTTON(By.cssSelector(".nav a[href='/podcasts/']")),
        TO_USER_HOME_CORNER_LINK(By.cssSelector("[href='/users/']")),


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
