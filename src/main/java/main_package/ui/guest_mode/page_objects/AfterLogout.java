package main_package.ui.guest_mode.page_objects;

import org.openqa.selenium.By;
import main_package.ui.BasePageObject;
import main_package.ui.engine.OnixLocator;
import main_package.ui.engine.OnixWebDriver;
import main_package.ui.guest_mode.general_parts.Footer;
import main_package.ui.guest_mode.general_parts.MainHeader;

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
