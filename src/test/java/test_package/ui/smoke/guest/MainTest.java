package test_package.ui.smoke.guest;

import main_package.engine.test_engine.OnixUiTestRunner;
import main_package.ui.guest_mode.page_objects.main.Main;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.uncommons.reportng.HTMLReporter;

public class MainTest extends OnixUiTestRunner {
    Main main;
    @BeforeMethod
    public void openMain() {
        main = openSite();
    }

    @Test
    public void mainPageTest() {
        main.check(onixUiAssert);
        onixUiAssert.assertAll();
    }

    @Test
    public void clickGetStarted() {
        openSite().clickGetStartedButton().check(onixUiAssert);
        onixUiAssert.assertAll();
    }

    @Test
    public void clickPlayStore() {
        openSite().clickPlayStoreBannerButton().check(onixUiAssert);
        onixUiAssert.assertAll();
    }

    @Test
    public void clickAppStore() {
        openSite().clickAppStoreBannerButton().check(onixUiAssert);
        onixUiAssert.assertAll();
    }

    @Test
    public void clickMyInstagram() {
        openSite().clickMyInstagramBannerButton().check(onixUiAssert);
        onixUiAssert.assertAll();
    }

    @Test
    public void clickMyFacebook() {
        openSite().clickMyFacebookBannerButton().check(onixUiAssert);
        onixUiAssert.assertAll();
    }

    @Test
    public void clickPlayStoreInDownloadSection() {
        openSite().clickPlayStoreButtonInDownloadSection().check(onixUiAssert);
        onixUiAssert.assertAll();
    }

    @Test
    public void clickAppStoreButtonInDownloadSection() {
        openSite().clickAppStoreButtonInDownloadSection().check(onixUiAssert);
        onixUiAssert.assertAll();
    }

    @Test
    public void clickAboutChallenges() {
        openSite().clickAboutChallengesButton().check(onixUiAssert);
        onixUiAssert.assertAll();
    }

    @Test
    public void clickSeeMoreTransformations() {
        openSite().clickSeeMoreTransformationsButton().check(onixUiAssert);
        onixUiAssert.assertAll();
    }

    @Test
    public void signUpForFamousDailyEmails() {
        openSite().cheaterClickFamousDailyEmail().check(onixUiAssert);
        onixUiAssert.assertAll();
    }

    @Test
    public void clickFooterJsaLogo() {
        //TODO
    }

    @Test
    public void clickFooterTermsOfService() {
        openSite().clickFooterTermsOfService().check(onixUiAssert);
        onixUiAssert.assertAll();
    }

    @Test
    public void clickFooterCookiesPolicy() {
        openSite().clickFooterCookiesPolicy().check(onixUiAssert);
        onixUiAssert.assertAll();
    }

    @Test
    public void clickFooterPrivacyPolicy() {
        openSite().clickFooterPrivatePolicy().check(onixUiAssert);
        onixUiAssert.assertAll();
    }

    @Test
    public void clickFooterBlog() {
        openSite().clickFooterBlog().check(onixUiAssert);
        onixUiAssert.assertAll();
    }

    @Test
    public void clickFooterBugReports() {
        openSite().clickFooterBugReports().check(onixUiAssert);
        onixUiAssert.assertAll();
    }

    @Test
    public void clickFooterContactUs() {
        openSite().clickFooterContactUs().check(onixUiAssert);
        onixUiAssert.assertAll();
    }

    @Test
    public void clickFooterAccess() {
        openSite().clickFooterAccess().check(onixUiAssert);
        onixUiAssert.assertAll();
    }

    @Test
    public void clickFooterFaqs() {
        openSite().clickFooterFAQs().check(onixUiAssert);
        onixUiAssert.assertAll();
    }

    @Test
    public void clickFooterFacebook() {
        openSite().clickFooterFacebook().check(onixUiAssert);
        onixUiAssert.assertAll();
    }

    @Test
    public void clickFooterInstagram() {
        openSite().clickFooterInstagram().check(onixUiAssert);
        onixUiAssert.assertAll();
    }

    @Test
    public void clickFooterSpotify() {
        openSite().clickFooterSpotify().check(onixUiAssert);
        onixUiAssert.assertAll();
    }

    @Test
    public void clickFooterPlayStore() {
        openSite().clickFooterPlayStore().check(onixUiAssert);
        onixUiAssert.assertAll();
    }

    @Test
    public void clickFooterAppStore() {
        openSite().clickFooterAppStore().check(onixUiAssert);
        onixUiAssert.assertAll();
    }

    @Test
    public void clickHeaderPricing() {
        openSite().clickHeaderPricing().check(onixUiAssert);
        onixUiAssert.assertAll();
    }

    @Test
    public void clickHeaderJsaLogo() {
        openSite().clickHeaderJsaLogo().check(onixUiAssert);
        onixUiAssert.assertAll();
    }

    @Test
    public void clickHeaderTransformations() {
        openSite().clickHeaderTransformations().check(onixUiAssert);
        onixUiAssert.assertAll();
    }

    @Test
    public void clickHeaderChallenge() {
        openSite().clickHeaderChallenge().check(onixUiAssert);
        onixUiAssert.assertAll();
    }

    @Test
    public void clickHeaderMyPodcast() {
        openSite().clickHeaderMyPodcast().check(onixUiAssert);
        onixUiAssert.assertAll();
    }

    @Test
    public void clickHeaderMyBook() {
        //TODO
        log.error("This test is not written!");
    }

    @Test
    public void clickHeaderLogin() {
        openSite().clickHeaderLogin().check(onixUiAssert);
        onixUiAssert.assertAll();
    }

    @Test
    public void clickHeaderJoinNow() {
        openSite().clickHeaderJoinNow().check(onixUiAssert);
        onixUiAssert.assertAll();
    }


}
