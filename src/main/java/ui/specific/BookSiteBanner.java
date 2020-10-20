package ui.specific;

import org.openqa.selenium.By;
import ui.engine.OnixLocator;
import ui.engine.OnixWebDriver;

public class BookSiteBanner {
    OnixWebDriver driver;

    public BookSiteBanner(OnixWebDriver driver) {
        this.driver = driver;
    }

    //TODO
    public static void closeIfPresent(OnixWebDriver driver) {
        if (!driver.checkSetting("bookBannerClosed")) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (driver.isElementPresent(AppBanner.Locator.BANNER_CONTAINER)) {
                driver.findElement(AppBanner.Locator.CLOSE_UP_CORNER_BUTTON).click();
                driver.setSetting("bookBannerClosed", true);
            }
        }
    }

    public enum Locator implements OnixLocator {
        BANNER_CONTAINER(By.cssSelector(".book-site-banner[href='/not-a-diet-book/']")),
        CLOSE_UP_CORNER_BUTTON(By.cssSelector(".book-site-banner__close img")),


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
