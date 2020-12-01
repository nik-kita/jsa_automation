package test_package.automation.smoke;

import org.testng.annotations.Test;
import main_package.engine.test_engine.OnixTestRunner;

public class LogoutModeMainTest extends OnixTestRunner {

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
