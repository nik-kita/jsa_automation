package main_package.ui.related_sites;

import main_package.ui.BasePart;
import main_package.engine.OnixWebDriver;

public interface InCurrentTab extends BasePart {
    default OnixWebDriver backToJsa() {
        OnixWebDriver driver = getDriver();
        driver.back();
        getLogger().debug("go back to page with 'jsa' content");
        return driver;
    }
}
