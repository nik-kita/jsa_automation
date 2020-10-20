package ui.user_mode.general_parts;

import ui.engine.OnixLocator;
import org.openqa.selenium.By;
import ui.BasePart;
import ui.engine.OnixWebDriver;
import ui.user_mode.page_objects.Main;
import ui.user_mode.page_objects.Pricing;

public interface MainHeader extends BasePart {

    default Main goMainPage() {
        OnixWebDriver driver = getDriver();
        driver.findElement(HomePart.HeaderLocator.JSA_LOGO).click();
        return new Main(driver);
    }
    default Pricing goPricingPage() {
        OnixWebDriver driver = getDriver();
        driver.findElement(HeaderLocator.PRICING_HEADER_BUTTON).click();
        return new Pricing(driver);
    }

    enum HeaderLocator implements OnixLocator {
        JSA_LOGO(By.cssSelector("a[href='/'] img")),
        BOOK_LOGO(By.cssSelector(".nav a[href='/not-a-diet-book/'] img")),//TODO there are two books logos on this locator
        PRICING_HEADER_BUTTON(By.cssSelector(".nav a[href='/pricing/']")),
        TRANSFORMATIONS_HEADER_BUTTON(By.cssSelector(".nav a[href='/transformations/']")),
        CHALLENGE_HEADER_BUTTON(By.cssSelector(".nav a[href='/challenge/about/']")),

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
