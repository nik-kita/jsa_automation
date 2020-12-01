package main_package.ui.related_sites;

import main_package.engine.OnixLocator;
import main_package.ui.user_mode.JsaLoginBaseTestRunner;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FacebookGroupTest extends JsaLoginBaseTestRunner {
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
