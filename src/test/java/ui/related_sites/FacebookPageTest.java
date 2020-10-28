package ui.related_sites;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ui.OnixAssert;
import ui.OnixTestRunner;
import ui.engine.OnixLocator;

public class FacebookPageTest extends OnixTestRunner {
    FacebookPage facebookPage;
    @BeforeClass
    public void goFacebookPage() {
        facebookPage = openSite().clickFacebookBannerButton();
    }
    @Test(dataProvider = "getFacebookPageLocators")
    public void facebookPageTest(OnixLocator locator) {
        onixAssert.checkCountOfElementByLocator(locator, 1);
    }
    @DataProvider
    public Object[] getFacebookPageLocators() {
        return FacebookPage.Locator.values();
    }
}
