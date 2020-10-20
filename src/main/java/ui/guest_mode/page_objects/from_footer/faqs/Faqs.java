package ui.guest_mode.page_objects.from_footer.faqs;

import org.openqa.selenium.By;
import ui.BasePageObject;
import ui.engine.OnixLocator;
import ui.engine.OnixWebDriver;
import ui.guest_mode.general_parts.Footer;
import ui.guest_mode.general_parts.MainHeader;
import ui.guest_mode.page_objects.from_footer.ContactUs;

public class Faqs extends BasePageObject implements MainHeader, Footer {
    public Faqs(OnixWebDriver driver) {
        super(driver);
    }

    public boolean isThisPage() {
        return driver.isElementPresent(Locator.H1_TITLE);
    }

    public enum Locator implements OnixLocator {
        H1_TITLE(By.xpath("//h1[contains(text(), 'How can we help?'")),


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
