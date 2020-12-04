package test_package.ui.smoke.guest;

import main_package.engine.test_engine.OnixUiTestRunner;
import main_package.ui.guest_mode.general_parts.MainHeader;
import org.testng.annotations.Test;

public class MainGuestHeaderTest extends OnixUiTestRunner {
    MainHeader pageObject;
    public MainGuestHeaderTest(MainHeader pageObject) {
        this.pageObject = pageObject;
    }
    @Test
    public void clickHeaderPricing() {
        pageObject.clickHeaderPricing().check(onixUiAssert);
        onixUiAssert.assertAll();
    }

    @Test
    public void clickHeaderJsaLogo() {
        pageObject.clickHeaderJsaLogo().check(onixUiAssert);
        onixUiAssert.assertAll();
    }

    @Test
    public void clickHeaderTransformations() {
        pageObject.clickHeaderTransformations().check(onixUiAssert);
        onixUiAssert.assertAll();
    }

    @Test
    public void clickHeaderChallenge() {
        pageObject.clickHeaderChallenge().check(onixUiAssert);
        onixUiAssert.assertAll();
    }

    @Test
    public void clickHeaderMyPodcast() {
        pageObject.clickHeaderMyPodcast().check(onixUiAssert);
        onixUiAssert.assertAll();
    }

    @Test
    public void clickHeaderMyBook() {
        //TODO
        log.error("This test is not written!");
    }

    @Test
    public void clickHeaderLogin() {
        pageObject.clickHeaderLogin().check(onixUiAssert);
        onixUiAssert.assertAll();
    }

    @Test
    public void clickHeaderJoinNow() {
        pageObject.clickHeaderJoinNow().check(onixUiAssert);
        onixUiAssert.assertAll();
    }

}
