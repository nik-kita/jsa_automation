package main_package.ui.user_mode.page_objects.from_footer;

import org.openqa.selenium.By;
import main_package.ui.BasePageObject;
import main_package.ui.engine.OnixLocator;
import main_package.ui.engine.OnixWebDriver;
import main_package.ui.user_mode.general_parts.Footer;
import main_package.ui.user_mode.general_parts.MainHeader;

public class AccessAndDownload extends BasePageObject implements MainHeader, Footer {

    public AccessAndDownload(OnixWebDriver driver) {
        super(driver);
    }

    public boolean isThisPage() {
        logger.debug("check is this a 'AccessAndDownload' page");
        return driver.isElementPresent(Locator.H4_TITLE);
    }

    public enum Locator implements OnixLocator {
        H4_TITLE(By.xpath("//h4[contains(text(), 'Access & Download')]")),


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