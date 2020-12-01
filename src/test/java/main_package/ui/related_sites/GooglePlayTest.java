package main_package.ui.related_sites;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.engine.test_engine.OnixTestRunner;
import main_package.engine.OnixLocator;

public class GooglePlayTest extends OnixTestRunner {
    GooglePlayPage googlePlayPage;
    @BeforeClass
    public void goGooglePlay() {
        googlePlayPage = openSite().clickPlayStoreBannerButton();
    }
    @Test(dataProvider = "getPlayStoreLocators")
    public void googlePlayPageTest(OnixLocator locator) {
        onixUiAssert.checkCountOfElementByLocator(locator, 1);
    }
    @DataProvider
    public Object[] getPlayStoreLocators() {
        return GooglePlayPage.Locator.values();
    }
}
