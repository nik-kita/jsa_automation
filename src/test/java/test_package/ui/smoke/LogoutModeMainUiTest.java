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

    @Test
    public void clickMyInstagram() {
        openSite().clickMyInstagramBannerButton(onixUiAssert);
        onixUiAssert.assertAll();
    }

    @Test
    public void clickMyFacebook() {
        openSite().clickMyFacebookBannerButton(onixUiAssert);
        onixUiAssert.assertAll();
    }

    @Test
    public void clickPlayStoreInDownloadSection() {
        openSite().clickPlayStoreButtonInDownloadSection(onixUiAssert);
        onixUiAssert.assertAll();
    }

    @Test
    public void clickAppStoreButtonInDownloadSection() {
        openSite().clickAppStoreButtonInDownloadSection(onixUiAssert);
        onixUiAssert.assertAll();
    }

    @Test
    public void clickAboutChallenges() {
        openSite().clickAboutChallengesButton(onixUiAssert);
        onixUiAssert.assertAll();
    }

    @Test
    public void clickSeeMoreTransformations() {
        openSite().clickSeeMoreTransformationsButton(onixUiAssert);
        onixUiAssert.assertAll();
    }

    @Test
    public void signUpForFamousDailyEmails() {
        openSite().cheaterClickFamousDailyEmail(onixUiAssert);
        onixUiAssert.assertAll();
    }

    @Test
    public void clickJsaFooterLogo() {
        //TODO
    }

    @Test
    public void clickTermsOfService() {
        openSite().clickFooterTermsOfService(onixUiAssert);
        onixUiAssert.assertAll();
    }

    @Test
    public void clickCookiesPolicy() {
        openSite().clickFooterCookiesPolicy(onixUiAssert);
        onixUiAssert.assertAll();
    }

    @Test
    public void clickPrivacyPolicy() {
        openSite().clickFooterPrivatePolicy(onixUiAssert);
        onixUiAssert.assertAll();
    }

    @Test
    public void clickFooterBlog() {
        openSite().clickFooterBlog(onixUiAssert);
        onixUiAssert.assertAll();
    }

    @Test
    public void clickBuReports() {
        openSite().clickFooterBugReports(onixUiAssert);
        onixUiAssert.assertAll();
    }

    @Test
    public void clickContactUs() {
        openSite().clickFooterContactUs(onixUiAssert);
        onixUiAssert.assertAll();
    }

    @Test
    public void clickAccess() {
        openSite().clickFooterAccess(onixUiAssert);
        onixUiAssert.assertAll();
    }

    @Test
    public void clickFaqs() {
        openSite().clickFooterFAQs(onixUiAssert);
        onixUiAssert.assertAll();
    }

    @Test
    public void clickFooterFacebook() {
        openSite().clickFooterFacebook(onixUiAssert);
        onixUiAssert.assertAll();
    }

    @Test
    public void clickFooterInstagram() {
        openSite().clickFooterInstagram(onixUiAssert);
        onixUiAssert.assertAll();
    }

    @Test
    public void clickFooterSpotify() {
        openSite().clickFooterSpotify(onixUiAssert);
        onixUiAssert.assertAll();
    }

    @Test
    public void clickFooterPlayStore() {
        openSite().clickFooterPlayStore(onixUiAssert);
        onixUiAssert.assertAll();
    }

    @Test
    public void clickFooterAppStore() {
        openSite().clickFooterAppStore(onixUiAssert);
        onixUiAssert.assertAll();
    }

}
