package main_package.ui.guest_mode.page_objects.from_footer;

import main_package.engine.test_engine.FlyTester;
import main_package.engine.test_engine.OnixUiAssert;
import org.openqa.selenium.By;
import main_package.ui.BasePageObject;
import main_package.engine.OnixLocator;
import main_package.engine.OnixWebDriver;
import main_package.ui.guest_mode.general_parts.Footer;
import main_package.ui.guest_mode.general_parts.MainHeader;

public class CookiesPolicy extends BasePageObject implements MainHeader, Footer {
    public CookiesPolicy(OnixWebDriver driver) {
        super(driver);
        logger.debug("'Cookies Policy' page is open.");
    }
    public CookiesPolicy check(OnixUiAssert onixUiAssert) {
        for(OnixLocator l : OnixUiAssert.mergeArrays(
                CookiesPolicy.Locator.values(),
                Footer.FooterLocator.values(),
                MainHeader.HeaderLocator.values()
        )) {
            onixUiAssert.softCheckCountOfElementByLocator(l, 1);
        }
        return this;
    }
    @Override
    public CookiesPolicy test(FlyTester flyTester) {
        flyTester.test();
        return this;
    }

    public boolean isThisPage() {
        logger.debug("check is this is a 'CookiesPolicy' page");
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
