package ui.specific;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ui.BasePageObject;
import ui.BasePart;
import ui.BaseStatic;
import ui.engine.OnixLocator;
import ui.engine.OnixWebDriver;

public class AppBanner extends BaseSpecific implements BasePart {

    public AppBanner(OnixWebDriver driver, Logger logger) {
        super(driver, logger);
    }

    public OnixWebDriver closeIfPresent(OnixWebDriver driver) {
        if (driver.isElementPresent(Locator.BANNER_CONTAINER)) {
            driver.findElement(Locator.CLOSE_UP_CORNER_BUTTON).click();
            driver.setSetting("appBannerClosed", true);
            logger.debug("close 'AppBanner'");
        }
        logger.warn("try close 'AppBanner' but it isn't present");
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
        BANNER_CONTAINER(By.cssSelector(".banner_container")),
        CLOSE_UP_CORNER_BUTTON(By.cssSelector(".banner_container__close a")),


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
