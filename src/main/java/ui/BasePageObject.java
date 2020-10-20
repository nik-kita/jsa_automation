package ui;

import ui.engine.OnixWebDriver;
import ui.specific.BookSiteBanner;
import ui.specific.JsaCookies;

public class BasePageObject {
    protected OnixWebDriver driver;

    public BasePageObject(OnixWebDriver driver) {
        JsaCookies.acceptIfCookiesPresent(driver);
        this.driver = driver;
    }

    public OnixWebDriver getDriver() {
        return driver;
    }
}
