package test_package.ui.smoke;

import main_package.engine.test_engine.OnixUiTestRunner;
import org.testng.annotations.Test;

public class LogoutModeMainUiTest extends OnixUiTestRunner {


    @Test
    public void mainPageTest() {
        openSite(onixUiAssert);
    }

    @Test
    public void clickGetStarted() {
        openSite().clickGetStartedButton(onixUiAssert);
    }

    @Test
    public void clickPlayStore() {
        openSite().clickPlayStoreBannerButton(onixUiAssert);
    }

    @Test
    public void clickAppStore() {
        openSite().clickAppStoreBannerButton(onixUiAssert);
    }

    @Test
    public void clickMyInstagram() {
        openSite().clickMyInstagramBannerButton(onixUiAssert);
    }

    @Test
    public void clickMyFacebook() {
        openSite().clickMyFacebookBannerButton(onixUiAssert);
    }

    @Test
    public void clickPlayStoreInDownloadSection() {
        openSite().clickPlayStoreButtonInDownloadSection(onixUiAssert);
    }

    @Test
    public void clickAppStoreButtonInDownloadSection() {
        openSite().clickAppStoreButtonInDownloadSection(onixUiAssert);
    }

    @Test
    public void clickAboutChallenges() {
        openSite().clickAboutChallengesButton(onixUiAssert);
    }

    @Test
    public void clickSeeMoreTransformations() {
        openSite().clickSeeMoreTransformationsButton(onixUiAssert);
    }

    @Test
    public void signUpForFamousDailyEmails() {
        openSite().cheaterClickFamousDailyEmail(onixUiAssert);
    }

    @Test
    public void clickJsaFooterLogo() {
        //TODO
    }

    @Test
    public void clickTermsOfService() {
        openSite().clickFooterTermsOfService(onixUiAssert);
    }

    @Test
    public void clickCookiesPolicy() {
        openSite().clickFooterCookiesPolicy(onixUiAssert);
    }

    @Test
    public void clickPrivacyPolicy() {
        openSite().clickFooterPrivatePolicy(onixUiAssert);
    }
    @Test
    public void clickFooterBlog() {
        openSite().clickFooterBlog(onixUiAssert);
    }
    @Test
    public void clickBuReports() {
        openSite().clickFooterBugReports(onixUiAssert);
    }
    @Test
    public void clickContactUs() {
        openSite().clickFooterContactUs(onixUiAssert);
    }
    @Test
    public void clickAccess() {
        openSite().clickFooterAccess(onixUiAssert);
    }

    @Test
    public void clickFaqs() {
        openSite().clickFooterFAQs(onixUiAssert);
    }

    @Test
    public void clickFooterFacebook() {
        openSite().clickFooterFacebook(onixUiAssert);
    }
    @Test
    public void clickFooterInstagram() {
        openSite().clickFooterInstagram(onixUiAssert);
    }
    @Test
    public void clickFooterSpotify() {
        openSite().clickFooterSpotify(onixUiAssert);
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
