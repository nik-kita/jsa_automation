package ui.smoke.logout;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ui.OnixAssert;
import ui.OnixTestRunner;
import ui.engine.OnixLocator;
import ui.guest_mode.page_objects.main.Main;

public class MainPageTest extends OnixTestRunner {

    @BeforeClass
    public void goHomePage() {
        openSite();
    }

    @Test(dataProvider = "getGeneralHeaderLocators")
    public void generalHeaderTest(OnixLocator locator) {
        openSite();
        new OnixAssert(getDriver()).
                checkCountOfElementByLocator(locator, 1);
    }

    @DataProvider
    public Object[] getGeneralHeaderLocators() {
        return Main.HeaderLocator.values();
    }

    @Test(dataProvider = "getMainPageLocators")
    public void mainPageTest(OnixLocator locator) {
        new OnixAssert(getDriver()).
                checkCountOfElementByLocator(locator, 1);
    }

    @DataProvider
    public Object[] getMainPageLocators() {
        return Main.Locator.values();
    }

    @Test(dataProvider = "getGeneralFooterLocators")
    public void generalFooterTest(OnixLocator locator) {
        new OnixAssert(getDriver()).
                checkCountOfElementByLocator(locator, 1);
    }

    @DataProvider
    public Object[] getGeneralFooterLocators() {
        return Main.FooterLocator.values();
    }
}
