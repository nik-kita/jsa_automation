package ui.related_sites;

import org.checkerframework.checker.units.qual.A;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ui.OnixAssert;
import ui.OnixTestRunner;
import ui.engine.OnixLocator;

public class AppStoreTest extends OnixTestRunner {
    AppStorePage appStorePage;
    @BeforeClass
    public void goAppStorePage() {
        appStorePage = openSite().clickAppStoreBannerButton();
    }
    @Test(dataProvider = "getAppStorePageLocators")
    public void appStoreTest(OnixLocator locator) {
        onixAssert.checkCountOfElementByLocator(locator, 1);
    }
    @DataProvider
    public Object[] getAppStorePageLocators() {
        return AppStorePage.Locator.values();
    }
}
