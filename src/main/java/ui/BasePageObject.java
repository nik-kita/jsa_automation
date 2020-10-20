package ui;

import ui.engine.OnixWebDriver;
import ui.specific_pages.JsaCookies;

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
