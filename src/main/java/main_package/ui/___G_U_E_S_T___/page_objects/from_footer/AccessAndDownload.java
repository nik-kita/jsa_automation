package main_package.ui.___G_U_E_S_T___.page_objects.from_footer;

import main_package.engine.test_engine.FlyTester;
import main_package.engine.test_engine.OnixUiAssert;
import org.openqa.selenium.By;
import main_package.ui.BasePageObject;
import main_package.engine.OnixLocator;
import main_package.engine.OnixWebDriver;
import main_package.ui.___G_U_E_S_T___.general_parts.Footer;
import main_package.ui.___G_U_E_S_T___.general_parts.MainHeader;

public class AccessAndDownload extends BasePageObject implements MainHeader, Footer {

    public AccessAndDownload(OnixWebDriver driver) {
        super(driver);
        logger.debug("'Access And Download' page is open.");
    }
    public AccessAndDownload check(OnixUiAssert onixUiAssert) {
        for(OnixLocator l : OnixUiAssert.mergeArrays(
                AccessAndDownload.Locator.values(),
                MainHeader.HeaderLocator.values(),
                Footer.FooterLocator.values()
        )) {
            onixUiAssert.softCheckCountOfElementByLocator(l, 1);
        }
        return this;
    }
    @Override
    public AccessAndDownload test(FlyTester flyTester) {
        flyTester.test();
        return this;
    }

    public boolean isThisPage() {
        logger.debug("check is this is a 'Access and Download' page");
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
