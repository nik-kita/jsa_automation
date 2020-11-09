package ui;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ui.engine.OnixWebDriver;
import ui.specific.BookSiteBanner;
import ui.specific.JsaCookies;

public class BasePageObject {
    protected OnixWebDriver driver;
    public Logger logger;

    public BasePageObject(OnixWebDriver driver) {
        logger = LoggerFactory.getLogger(this.getClass());
        this.driver = new JsaCookies(driver, logger).acceptIfCookiesPresent();
    }

    public Logger getLogger() {
        return logger;
    }

    public OnixWebDriver getDriver() {
        return driver;
    }
}
