package main_package.ui.related_sites;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.engine.test_engine.OnixTestRunner;
import main_package.engine.OnixLocator;

public class InstagramPageTest extends OnixTestRunner {
    InstagramPage instagramPage;
    @BeforeClass
    public void goInstagramPage() {
        instagramPage = openSite().clickMyInstagramBannerButton();
    }
    @Test(dataProvider = "getInstagramPageLocators")
    public void instagramPageTest(OnixLocator locator) {
        onixUiAssert.checkCountOfElementByLocator(locator, 1);
    }
    @DataProvider
    public Object[] getInstagramPageLocators() {
        return InstagramPage.Locator.values();
    }
}
