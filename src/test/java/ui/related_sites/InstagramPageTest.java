package ui.related_sites;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ui.OnixAssert;
import ui.OnixTestRunner;
import ui.engine.OnixLocator;

public class InstagramPageTest extends OnixTestRunner {
    InstagramPage instagramPage;
    @BeforeClass
    public void goInstagramPage() {
        instagramPage = openSite().clickMyInstagramBannerButton();
    }
    @Test(dataProvider = "getInstagramPageLocators")
    public void instagramPageTest(OnixLocator locator) {
        new OnixAssert(driver).checkCountOfElementByLocator(locator, 1);
    }
    @DataProvider
    public Object[] getInstagramPageLocators() {
        return InstagramPage.Locator.values();
    }
}
