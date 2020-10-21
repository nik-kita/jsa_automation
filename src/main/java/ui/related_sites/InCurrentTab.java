package ui.related_sites;

import ui.BasePart;
import ui.engine.OnixWebDriver;

public interface InCurrentTab extends BasePart {
    default OnixWebDriver backToJsa() {
        OnixWebDriver driver = getDriver();
        driver.back();
        return driver;
    }
}
