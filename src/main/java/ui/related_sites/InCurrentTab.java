package ui.related_sites;

import ui.BasePart;
import ui.engine.OnixWebDriver;

public interface InCurrentTab extends BasePart {
    default OnixWebDriver backToJsa() {
        OnixWebDriver driver = getDriver();
        driver.back();
        getLogger().debug("go back to page with 'jsa' content");
        return driver;
    }
}
