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
        logger.debug("check is 'AfterLogout' page is opened");
        return driver.isElementPresent(successLogoutMessage);
    }

    public OnixLocator successLogoutMessage = makeOnixLocator(By.cssSelector(".jumbo-message"), this.getClass());
}
