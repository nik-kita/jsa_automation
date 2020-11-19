package main_package.ui.user_mode.page_objects.home_header.home.account;

import main_package.ui.BasePageObject;
import main_package.ui.engine.OnixLocator;
import main_package.ui.engine.OnixWebDriver;
import main_package.ui.user_mode.general_parts.Footer;
import main_package.ui.user_mode.general_parts.home.account.AccountHeader;
import main_package.ui.user_mode.general_parts.home.account.AccountSidebar;
import org.openqa.selenium.By;

public class PairedDevices extends BasePageObject implements AccountHeader, AccountSidebar, Footer {

    public PairedDevices(OnixWebDriver driver) {
        super(driver);
    }
    public enum Locator implements OnixLocator {
        CONNECT_TO_FITBIT_BUTTON(By.xpath("//a[contains(text(), 'Connect to Fitbit')]")),
        ;

        private By path;

        Locator(By path) {
            this.path = path;
        }

        @Override
        public By getPath() {
            return path;
        }
    }
}
