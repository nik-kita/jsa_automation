package main_package.ui.___G_U_E_S_T___.page_objects;

import main_package.engine.test_engine.FlyTester;
import main_package.engine.test_engine.OnixUiAssert;
import org.openqa.selenium.By;
import main_package.ui.BasePageObject;
import main_package.engine.OnixLocator;
import main_package.engine.OnixWebDriver;
import main_package.ui.___G_U_E_S_T___.general_parts.Footer;
import main_package.ui.___G_U_E_S_T___.general_parts.MainHeader;

public class AfterLogout extends BasePageObject implements Footer, MainHeader {
    public AfterLogout(OnixWebDriver driver) {
        super(driver);
    }
    @Override
    public AfterLogout test(FlyTester flyTester) {
        flyTester.test();
        return this;
    }

    public boolean isThisPage() {
        logger.debug("check is 'AfterLogout' page is opened");
        return driver.isElementPresent(successLogoutMessage);
    }

    public OnixLocator successLogoutMessage = makeOnixLocator(By.cssSelector(".jumbo-message"), this.getClass());

    @Override
    public BasePageObject check(OnixUiAssert onixUiAssert) {
        return null;
    }
}
