package ui.related_sites;

import ui.BasePart;
import ui.engine.OnixWebDriver;

public interface InAnotherTab extends BasePart {
    default OnixWebDriver closeAndBackToJsaTab() {
        OnixWebDriver driver = getDriver();
        driver.switchToRegisterTab("jsa");
        driver.closeTabsExceptCurrent();
        return driver;
    }
}
