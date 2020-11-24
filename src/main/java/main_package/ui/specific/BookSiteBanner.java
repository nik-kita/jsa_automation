package main_package.ui.specific;

import main_package.ui.engine.FlyTester;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import main_package.ui.BasePart;
import main_package.ui.engine.OnixLocator;
import main_package.ui.engine.OnixWebDriver;

public class BookSiteBanner extends BaseSpecific implements BasePart {

    public BookSiteBanner(OnixWebDriver driver, Logger logger) {
        super(driver, logger);
    }

    @Override
    public BookSiteBanner test(FlyTester flyTester) {
        flyTester.test();
        return this;
    }

    //TODO
    public OnixWebDriver closeIfPresent() {
        if (!driver.checkSetting("bookBannerClosed")) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (driver.isElementPresent(AppBanner.Locator.BANNER_CONTAINER)) {
                driver.findElement(AppBanner.Locator.CLOSE_UP_CORNER_BUTTON).click();
                driver.setSetting("bookBannerClosed", true);
                logger.debug("close 'BookSiteBanner");
            }
            logger.warn("try to close 'BookSiteBanner' but no such elements");
        }
        logger.trace("try close 'BookSiteBanner' but it was already done");
        return driver;
    }

    @Override
    public Logger getLogger() {
        return logger;
    }

    @Override
    public OnixWebDriver getDriver() {
        return driver;
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
