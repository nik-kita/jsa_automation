package main_package.ui.guest_mode.page_objects.from_footer;

import main_package.engine.test_engine.FlyTester;
import org.openqa.selenium.By;
import main_package.ui.BasePageObject;
import main_package.engine.OnixLocator;
import main_package.engine.OnixWebDriver;
import main_package.ui.guest_mode.general_parts.Footer;
import main_package.ui.guest_mode.general_parts.MainHeader;

public class ContactUs extends BasePageObject implements MainHeader, Footer {
    public ContactUs(OnixWebDriver driver) {
        super(driver);
    }
    @Override
    public ContactUs test(FlyTester flyTester) {
        flyTester.test();
        return this;
    }
    public boolean isThisPage() {
        logger.debug("check is this is a 'Contact Us' page");
        return driver.isElementPresent(Locator.H1_TITLE);
    }

    public enum Locator implements OnixLocator {
        H1_TITLE(By.xpath("//h1[contains(text(), 'Contact Us')]")),


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
