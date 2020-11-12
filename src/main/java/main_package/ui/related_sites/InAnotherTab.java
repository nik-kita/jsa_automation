package main_package.ui.related_sites;

import main_package.ui.BasePart;
import main_package.ui.engine.OnixWebDriver;

public interface InAnotherTab extends BasePart {
    default OnixWebDriver closeAndBackToJsaTab() {
        OnixWebDriver driver = getDriver();
        driver.switchToRegisterTab("jsa");
        driver.closeTabsExceptCurrent();
        getLogger().debug("close '" + this.getClass() + "' and back to tab with 'jsa' content");
        return driver;
    }
}
