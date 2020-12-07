package main_package.ui.___U_S_E_R___.page_objects.from_footer;

import main_package.engine.test_engine.FlyTester;
import org.openqa.selenium.By;
import main_package.ui.BasePageObject;
import main_package.engine.OnixLocator;
import main_package.engine.OnixWebDriver;
import main_package.ui.___U_S_E_R___.general_parts.Footer;
import main_package.ui.___U_S_E_R___.general_parts.MainHeader;

public class ReportBugs extends BasePageObject implements MainHeader, Footer {
    public ReportBugs(OnixWebDriver driver) {
        super(driver);
    }
    @Override
    public ReportBugs test(FlyTester flyTester) {
        flyTester.test();
        return this;
    }

    public boolean isThisPage() {
        logger.debug("check is this is a 'ReportBugs' page");
        return driver.isElementPresent(Locator.H1_TITLE);
    }

    public enum Locator implements OnixLocator {
        H1_TITLE(By.xpath("//h1[contains(text(), 'Report Bugs')]")),


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
