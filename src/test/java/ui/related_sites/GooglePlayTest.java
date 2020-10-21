package ui.related_sites;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ui.OnixAssert;
import ui.OnixTestRunner;
import ui.engine.OnixLocator;

public class GooglePlayTest extends OnixTestRunner {
    GooglePlayPage googlePlayPage;
    @BeforeClass
    public void goGooglePlay() {
        googlePlayPage = openSite().clickPlayStoreBannerButton();
    }
    @Test(dataProvider = "getPlayStoreLocators")
    public void googlePlayPageTest(OnixLocator locator) {
        new OnixAssert(driver).checkCountOfElementByLocator(locator, 1);
    }
    @DataProvider
    public Object[] getPlayStoreLocators() {
        return GooglePlayPage.Locator.values();
    }
}
