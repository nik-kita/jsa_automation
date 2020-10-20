package ui.guest_mode.page_objects;

import org.openqa.selenium.By;
import ui.BasePageObject;
import ui.engine.OnixLocator;
import ui.engine.OnixWebDriver;
import ui.guest_mode.general_parts.Footer;
import ui.guest_mode.general_parts.MainHeader;

public class AfterLogout extends BasePageObject implements Footer, MainHeader {
    public AfterLogout(OnixWebDriver driver) {
        super(driver);
    }

    public boolean isThisPage() {
        return driver.isElementPresent(successLogoutMessage);
    }

    OnixLocator successLogoutMessage = OnixLocator.makeOnixLocator(By.cssSelector(".jumbo-message"));
}
