package main_package.ui.guest_mode.page_objects.from_footer.faqs;

import org.openqa.selenium.By;
import main_package.ui.BasePageObject;
import main_package.ui.engine.OnixLocator;
import main_package.ui.engine.OnixWebDriver;
import main_package.ui.guest_mode.general_parts.Footer;
import main_package.ui.guest_mode.general_parts.MainHeader;

public class Faqs extends BasePageObject implements MainHeader, Footer {
    public Faqs(OnixWebDriver driver) {
        super(driver);
    }

    public boolean isThisPage() {
        logger.debug("check is this 'FAQS' page");
        return driver.isElementPresent(Locator.H1_TITLE);
    }

    public enum Locator implements OnixLocator {
        H1_TITLE(By.xpath("//h1[contains(text(), 'How can we help?')]")),


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
