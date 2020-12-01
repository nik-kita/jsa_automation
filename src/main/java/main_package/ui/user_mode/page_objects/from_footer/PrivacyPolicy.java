package main_package.ui.user_mode.page_objects.from_footer;

import main_package.engine.test_engine.FlyTester;
import org.openqa.selenium.By;
import main_package.ui.BasePageObject;
import main_package.engine.OnixLocator;
import main_package.engine.OnixWebDriver;
import main_package.ui.user_mode.general_parts.Footer;
import main_package.ui.user_mode.general_parts.MainHeader;

public class PrivacyPolicy extends BasePageObject implements MainHeader, Footer {
    public PrivacyPolicy(OnixWebDriver driver) {
        super(driver);
    }
    @Override
    public PrivacyPolicy test(FlyTester flyTester) {
        flyTester.test();
        return this;
    }

    public boolean isThisPage() {
        logger.debug("check is this is a 'PrivacyPolicy' page");
        return driver.isElementPresent(Locator.H4_TITLE);
    }

    public enum Locator implements OnixLocator {
        H4_TITLE(By.xpath("//h4[contains(text(), 'Privacy Policy')]")),


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
