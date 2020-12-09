package main_package.ui.___U_S_E_R___.page_objects.from_footer.faqs;

import main_package.engine.test_engine.FlyTester;
import org.openqa.selenium.By;
import main_package.ui.BasePageObject;
import main_package.engine.OnixLocator;
import main_package.engine.OnixWebDriver;
import main_package.ui.___U_S_E_R___.general_parts.Footer;
import main_package.ui.___U_S_E_R___.general_parts.MainHeader;

public class Faqs extends BasePageObject implements MainHeader, Footer {
    public Faqs(OnixWebDriver driver) {
        super(driver);
    }
    @Override
    public Faqs test(FlyTester flyTester) {
        flyTester.test();
        return this;
    }
    public boolean isThisPage() {
        logger.debug("check is this is a 'Faqs' page");
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