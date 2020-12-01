package main_package.ui.related_sites;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.engine.test_engine.OnixTestRunner;
import main_package.engine.OnixLocator;

public class AppStoreTest extends OnixTestRunner {
    AppStorePage appStorePage;
    @BeforeClass
    public void goAppStorePage() {
        appStorePage = openSite().clickAppStoreBannerButton();
    }
    @Test(dataProvider = "getAppStorePageLocators")
    public void appStoreTest(OnixLocator locator) {
        onixUiAssert.checkCountOfElementByLocator(locator, 1);
    }
    @DataProvider
    public Object[] getAppStorePageLocators() {
        return AppStorePage.Locator.values();
    }
}
