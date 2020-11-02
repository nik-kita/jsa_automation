package automation;

import io.qameta.allure.Allure;
import io.qameta.allure.AllureLifecycle;
import io.qameta.allure.testng.AllureTestNg;
import org.checkerframework.checker.units.qual.A;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ui.OnixTestRunner;
import ui.data.User;
import ui.engine.OnixLocator;
import ui.guest_mode.page_objects.from_footer.*;
import ui.guest_mode.page_objects.from_footer.faqs.Faqs;
import ui.guest_mode.page_objects.main.Main;
import ui.guest_mode.page_objects.main.Transformations;
import ui.guest_mode.page_objects.main.login.CreateAccount;
import ui.guest_mode.page_objects.main.login.ResetPassword;
import ui.related_sites.*;
import ui.user_mode.page_objects.home_header.home.Home;
import ui.user_mode.page_objects.main.pricing.pricingplans.PaymentMethodPopup;

import java.io.FileNotFoundException;
@Test(testName = "WS")
public class WS extends OnixTestRunner {
    Main main;

    @BeforeClass
    public void startFromMainPage() {
        main = openSite();
        log.info("open site");
    }

    @Test
    public void pricing() throws FileNotFoundException {
        Allure.link("Original test case", "https://docs.google.com/spreadsheets/d/1gudjZ7fh4aUsozP7aPIovLnI4qGdbUFpIHJ6AbTlbC4/edit?ts=5f7593b0#gid=633091546&range=B12");


        PaymentMethodPopup paymentMethodPopup = main
                .goLoginPage()
                .login(User.getValidUser())
                .goMainPage()
                .goPricingPage()
                .goPricingPlans()
                .subscribeStandard();
        for (OnixLocator l : PaymentMethodPopup.Locator.values()) {
            onixAssert.softCheckCountOfElementByLocator(l, 1);
        }
        paymentMethodPopup = paymentMethodPopup
                .exit()
                .subscribePremium();
        for (OnixLocator l : PaymentMethodPopup.Locator.values()) {
            onixAssert.softCheckCountOfElementByLocator(l, 1);
        }
        paymentMethodPopup = paymentMethodPopup
                .exit()
                .buyNow();
        for (OnixLocator l : PaymentMethodPopup.Locator.values()) {
            onixAssert.softCheckCountOfElementByLocator(l, 1);
        }
        main = paymentMethodPopup
                .exit()
                .clickLogoutHeaderButton()
                .goMainPage();
        onixAssert.assertAll();
    }

    @Test
    public void transformations() {
        Allure.link("Original test case", "https://docs.google.com/spreadsheets/d/1gudjZ7fh4aUsozP7aPIovLnI4qGdbUFpIHJ6AbTlbC4/edit?ts=5f7593b0#gid=633091546&range=B22");

        Transformations transformations = main
                .clickSeeMoreTransformationsButton();
        int before = Integer.MIN_VALUE;
        while (transformations.seeMore()) {
            int current = transformations.countTransformations();
            onixAssert.softCheckFirstGreaterSecond(current, before);
            before = current;
        }
        main = transformations.goMainPage();
        onixAssert.assertAll();
    }

    @Test
    public void blog() {
        Allure.link("Original test case","https://docs.google.com/spreadsheets/d/1gudjZ7fh4aUsozP7aPIovLnI4qGdbUFpIHJ6AbTlbC4/edit#gid=633091546&range=B40");

        Blog blog = main.goBlogPageFromFooter();
        int total = blog.countPosts();
        int fromEveryTab = 0;
        for (OnixLocator l : Blog.Locator.values()) {
            driver.findElement(l).click();
            fromEveryTab += blog.countPosts();
        }
        fromEveryTab -= total;
        main = blog.goMainPage();
        onixAssert.checkCount(total, fromEveryTab);
    }

    @Test
    public void login() {
        Allure.link("Original test case", "https://docs.google.com/spreadsheets/d/1gudjZ7fh4aUsozP7aPIovLnI4qGdbUFpIHJ6AbTlbC4/edit?ts=5f7593b0#gid=633091546&range=B53");

        Home home = main.goLoginPage().login(User.getValidUser());
        onixAssert.softCheckCountOfElementByLocator(Home.Locator.CHALLENGE_DIV_LINK, 1);
        main = home.openUserDropDown().logout().goMainPage();
        ResetPassword resetPassword = main.goLoginPage().clickForgotPassword();
        onixAssert.softCheckCountOfElementByLocator(ResetPassword.Locator.EMAIL_INPUT, 1);
        main = resetPassword.goMainPage();
        home = main.goLoginPage().loginByFB(User.getValidUser());
        onixAssert.softCheckCountOfElementByLocator(Home.Locator.CHALLENGE_DIV_LINK, 1);
        main = home.openUserDropDown().logout().goMainPage();
        CreateAccount createAccount = main.clickGetStartedButton();
        onixAssert.softCheckCountOfElementByLocator(CreateAccount.Locator.CREATE_ACCOUNT_BUTTON, 1);
        main = createAccount.goMainPage();
        onixAssert.assertAll();
    }

    @Test
    public void footer() {
        Allure.link("Original test case", "https://docs.google.com/spreadsheets/d/1gudjZ7fh4aUsozP7aPIovLnI4qGdbUFpIHJ6AbTlbC4/edit#gid=633091546&range=B84");

        TermsOfService termsOfService = main.goTermsOfServiceFromFooter();
        onixAssert.softCheckCountOfElementByLocator(TermsOfService.Locator.H4_TITLE, 1);
        CookiesPolicy cookiesPolicy = termsOfService.goCookiesPolicyFromFooter();
        onixAssert.softCheckCountOfElementByLocator(CookiesPolicy.Locator.H4_TITLE, 1);
        PrivacyPolicy privacyPolicy = cookiesPolicy.goPrivacyPolicyFromFooter();
        onixAssert.softCheckCountOfElementByLocator(PrivacyPolicy.Locator.H4_TITLE, 1);
        ReportBugs reportBugs = privacyPolicy.goReportBugsFromFooter();
        onixAssert.softCheckCountOfElementByLocator(ReportBugs.Locator.H1_TITLE, 1);
        ContactUs contactUs = reportBugs.goContactUsFromFooter();
        onixAssert.softCheckCountOfElementByLocator(ContactUs.Locator.H1_TITLE, 1);
        AccessAndDownload accessAndDownload = contactUs.goAccessAndDownloadFromFooter();
        onixAssert.softCheckCountOfElementByLocator(AccessAndDownload.Locator.H4_TITLE, 1);
        Faqs faqs = accessAndDownload.goFaqsFromFooter();
        onixAssert.softCheckCountOfElementByLocator(Faqs.Locator.H1_TITLE, 1);
        GooglePlayPage googlePlayPage = faqs.downloadAppPlayStoreFromFooter();
        onixAssert.softCheckCountOfElementByLocator(GooglePlayPage.Locator.GOOGLE_PLAY_LOGO, 1);
        faqs = new Faqs(googlePlayPage.backToJsa());
        AppStorePage appStorePage = faqs.downloadAppAppStoreFromFooter();
        onixAssert.softCheckCountOfElementByLocator(AppStorePage.Locator.APPLE_LOGO, 1);
        faqs = new Faqs(appStorePage.backToJsa());
        InstagramPage instagramPage = faqs.clickInstagramFromFooter();
        onixAssert.softCheckCountOfElementByLocator(InstagramPage.Locator.INSTAGRAM_LOGO, 1);
        faqs = new Faqs(instagramPage.closeAndBackToJsaTab());
        FacebookPage facebookPage = faqs.clickFacebookFromFooter();
        onixAssert.softCheckCountOfElementByLocator(FacebookPage.Locator.FACEBOOK_LOGO, 1);
        faqs = new Faqs(facebookPage.closeAndBackToJsaTab());
        SpotifyPage spotifyPage = faqs.clickSpotifyFromFooter();
        onixAssert.softCheckUrlContains("spotify");
        main = new Faqs(spotifyPage.closeAndBackToJsaTab()).goMainPage();
        onixAssert.assertAll();
    }
}
