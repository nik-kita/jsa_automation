package test_package.ui.smoke;

import main_package.engine.test_engine.OnixUiTestRunner;
import org.testng.annotations.Test;

public class LogoutModeMainUiTest extends OnixUiTestRunner {

    @Test
    public void mainPageTest() {
        openSite(onixUiAssert);
        onixUiAssert.assertAll();
    }

    @Test
    public void clickGetStarted() {
        openSite().clickGetStartedButton(onixUiAssert);
        onixUiAssert.assertAll();
    }

    @Test
    public void clickPlayStore() {
        openSite().clickPlayStoreBannerButton(onixUiAssert);
        onixUiAssert.assertAll();
    }

    @Test
    public void clickAppStore() {
        openSite().clickAppStoreBannerButton(onixUiAssert);
        onixUiAssert.assertAll();
    }



}
