package ui.user_mode.page_objects.from_footer;

import org.openqa.selenium.By;
import ui.BasePageObject;
import ui.engine.OnixLocator;
import ui.engine.OnixWebDriver;
import ui.user_mode.general_parts.Footer;
import ui.user_mode.general_parts.MainHeader;

public class CookiesPolicy extends BasePageObject implements MainHeader, Footer {
    public CookiesPolicy(OnixWebDriver driver) {
        super(driver);
    }

    public boolean isThisPage() {
        return driver.isElementPresent(Locator.H4_TITLE);
    }

    public enum Locator implements OnixLocator {
        H4_TITLE(By.xpath("//h4[contains(text(), 'Cookies Policy')]")),


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
