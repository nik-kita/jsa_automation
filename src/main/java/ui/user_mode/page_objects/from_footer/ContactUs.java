package ui.user_mode.page_objects.from_footer;

import org.openqa.selenium.By;
import ui.BasePageObject;
import ui.engine.OnixLocator;
import ui.engine.OnixWebDriver;
import ui.user_mode.general_parts.Footer;
import ui.user_mode.general_parts.MainHeader;

public class ContactUs extends BasePageObject implements MainHeader, Footer {
    public ContactUs(OnixWebDriver driver) {
        super(driver);
    }

    public boolean isThisPage() {
        return driver.isElementPresent(Locator.H1_TITLE);
    }

    public enum Locator implements OnixLocator {
        H1_TITLE(By.xpath("//h1[contains(text(), 'Contact Us'")),


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