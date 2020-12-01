package test_package.automation.smoke;

import org.testng.Reporter;
import org.testng.annotations.Test;
import test_package.test_engine.OnixTestRunner;

public class LogoutModeMainTest extends OnixTestRunner {

    @Test
    public void mainPageTest() {
        openSite(onixAssert);
        onixAssert.assertAll();
    }

    @Test
    public void clickGetStarted() {
        openSite().clickGetStartedButton(onixAssert);
        onixAssert.assertAll();
    }

    @Test
    public void clickPlayStore() {
        openSite().clickPlayStoreBannerButton(onixAssert);
        onixAssert.assertAll();
    }

    @Test
    public void clickAppStore() {
        openSite().clickAppStoreBannerButton(onixAssert);
        onixAssert.assertAll();
    }



}
