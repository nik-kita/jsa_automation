package ui.smoke.login;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ui.OnixAssert;
import ui.engine.OnixLocator;
import ui.user_mode.general_parts.Footer;
import ui.user_mode.general_parts.MainHeader;
import ui.user_mode.page_objects.Main;

public class MainLoginModeTest extends JsaLoginBaseTestRunner {
    Main mainLoginModePO;
    @BeforeClass
    public void goMain() {
        mainLoginModePO = homeLoginModePO.goMainPage();
    }

    @Test(dataProvider = "getGeneralHeaderLoginModeLocators")
    public void generalHeaderLoginModeTest(OnixLocator locator) {
        new OnixAssert(driver).checkCountOfElementByLocator(locator, 1);
    }
    @DataProvider
    public Object[] getGeneralHeaderLoginModeLocators() {
        return Main.HeaderLocator.values();
    }

    @Test(dataProvider = "getMainPageLocators")
    public void checkMainPageSameAsLogout(OnixLocator locator) {
        new OnixAssert(getDriver()).
                checkCountOfElementByLocator(locator, 1);
    }

    @DataProvider
    public Object[] getMainPageLocators() {
        return Main.Locator.values();
    }

    @Test(dataProvider = "getGeneralFooterLocators")
    public void checkGeneralFooterSameAsLogoutTest(OnixLocator locator) {
        new OnixAssert(getDriver()).
                checkCountOfElementByLocator(locator, 1);
    }

    @DataProvider
    public Object[] getGeneralFooterLocators() {
        return Main.FooterLocator.values();
    }

}
