package main_package.ui.guest_mode.page_objects.from_footer;

import main_package.ui.engine.FlyTester;
import org.openqa.selenium.By;
import main_package.ui.BasePageObject;
import main_package.ui.engine.OnixLocator;
import main_package.ui.engine.OnixWebDriver;
import main_package.ui.guest_mode.general_parts.Footer;
import main_package.ui.guest_mode.general_parts.MainHeader;

public class TermsOfService extends BasePageObject implements Footer, MainHeader {

    public TermsOfService(OnixWebDriver driver) {
        super(driver);
    }
    @Override
    public TermsOfService test(FlyTester flyTester) {
        flyTester.test();
        return this;
    }

    public boolean isThisPage() {
        logger.debug("check is this is a 'Terms of Service' page");
        return driver.isElementPresent(Locator.H4_TITLE);
    }

    public enum Locator implements OnixLocator {
        //TODO
        H4_TITLE(By.xpath("//h4[contains(text(), 'and Services Terms')]")),


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
