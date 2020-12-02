package test_package.unit.related_sites;

import main_package.engine.OnixLocator;
import main_package.ui.related_sites.FacebookGroupPage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.engine.test_engine.JsaLoginBaseUiTestRunner;

public class FacebookGroupUiTest extends JsaLoginBaseUiTestRunner {
    @BeforeClass
    public void openFacebookGroup() {
        homeLoginModePO.clickJoinNow();
    }
    @Test(dataProvider = "original")
    public void testFacebookGroup(OnixLocator locator) {
        onixUiAssert.checkCountOfElementByLocator(locator, 1);
    }
    @DataProvider
    public Object[] original() {
        return FacebookGroupPage.Locator.values();
    }
}
