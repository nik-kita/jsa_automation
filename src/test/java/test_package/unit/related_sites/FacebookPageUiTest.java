package test_package.unit.related_sites;

import main_package.engine.test_engine.OnixUiTestRunner;
import main_package.ui.related_sites.FacebookPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.engine.OnixLocator;

public class FacebookPageUiTest extends OnixUiTestRunner {
    FacebookPage facebookPage;
    @BeforeClass
    public void goFacebookPage() {
        facebookPage = openSite().clickMyFacebookBannerButton();
    }
    @Test(dataProvider = "getFacebookPageLocators")
    public void facebookPageTest(OnixLocator locator) {
        onixUiAssert.checkCountOfElementByLocator(locator, 1);
    }
    @DataProvider
    public Object[] getFacebookPageLocators() {
        return FacebookPage.Locator.values();
    }
}
