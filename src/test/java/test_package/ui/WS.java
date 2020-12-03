package test_package.ui;

import io.qameta.allure.Allure;
import main_package.engine.test_engine.OnixUiTestRunner;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import main_package.ui.data.User;
import main_package.engine.OnixLocator;
import main_package.ui.guest_mode.page_objects.from_footer.*;
import main_package.ui.guest_mode.page_objects.from_footer.faqs.Faqs;
import main_package.ui.guest_mode.page_objects.main.Main;
import main_package.ui.guest_mode.page_objects.main.Transformations;
import main_package.ui.guest_mode.page_objects.main.login.CreateAccount;
import main_package.ui.guest_mode.page_objects.main.login.ResetPassword;
import main_package.ui.related_sites.*;
import main_package.ui.user_mode.page_objects.home_header.home.Home;
import main_package.ui.user_mode.page_objects.main.pricing.pricingplans.PaymentMethodPopup;

import java.io.FileNotFoundException;
@Test(testName = "WS")
public class WS extends OnixUiTestRunner {
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
            onixUiAssert.softCheckCountOfElementByLocator(l, 1);
        }
        paymentMethodPopup = paymentMethodPopup
                .exit()
                .subscribePremium();
        for (OnixLocator l : PaymentMethodPopup.Locator.values()) {
            onixUiAssert.softCheckCountOfElementByLocator(l, 1);
        }
        paymentMethodPopup = paymentMethodPopup
                .exit()
                .buyNow();
        for (OnixLocator l : PaymentMethodPopup.Locator.values()) {
            onixUiAssert.softCheckCountOfElementByLocator(l, 1);
        }
        main = paymentMethodPopup
                .exit()
                .clickLogoutHeaderButton()
                .goMainPage();
        onixUiAssert.assertAll();
    }

    @Test
    public void transformations() {
        Allure.link("Original test case", "https://docs.google.com/spreadsheets/d/1gudjZ7fh4aUsozP7aPIovLnI4qGdbUFpIHJ6AbTlbC4/edit?ts=5f7593b0#gid=633091546&range=B22");

        Transformations transformations = main
                .clickSeeMoreTransformationsButton();
        int before = Integer.MIN_VALUE;
        while (transformations.seeMore()) {
            int current = transformations.countTransformations();
            onixUiAssert.softCheckFirstGreaterSecond(current, before);
            before = current;
        }
        main = transformations.goMainPage();
        onixUiAssert.assertAll();
    }

    @Test
    public void blog() {
        Allure.link("Original test case","https://docs.google.com/spreadsheets/d/1gudjZ7fh4aUsozP7aPIovLnI4qGdbUFpIHJ6AbTlbC4/edit#gid=633091546&range=B40");

        Blog blog = main.clickFooterBlog();
        int total = blog.countPosts();
        int fromEveryTab = 0;
        for (OnixLocator l : Blog.Locator.values()) {
            driver.findElement(l).click();
            fromEveryTab += blog.countPosts();
        }
        fromEveryTab -= total;
        main = blog.goMainPage();
        onixUiAssert.checkCount(total, fromEveryTab);
    }

    @Test
    public void login() {
        Allure.link("Original test case", "https://docs.google.com/spreadsheets/d/1gudjZ7fh4aUsozP7aPIovLnI4qGdbUFpIHJ6AbTlbC4/edit?ts=5f7593b0#gid=633091546&range=B53");

        Home home = main.goLoginPage().login(User.getValidUser());
        onixUiAssert.softCheckCountOfElementByLocator(Home.Locator.CHALLENGE_DIV_LINK, 1);
        main = home.openUserDropDown().logout().goMainPage();
        ResetPassword resetPassword = main.goLoginPage().clickForgotPassword();
        onixUiAssert.softCheckCountOfElementByLocator(ResetPassword.Locator.EMAIL_INPUT, 1);
        main = resetPassword.goMainPage();
        home = main.goLoginPage().loginByFB(User.getValidUser());
        onixUiAssert.softCheckCountOfElementByLocator(Home.Locator.CHALLENGE_DIV_LINK, 1);
        main = home.openUserDropDown().logout().goMainPage();
        CreateAccount createAccount = main.clickGetStartedButton();
        onixUiAssert.softCheckCountOfElementByLocator(CreateAccount.Locator.CREATE_ACCOUNT_BUTTON, 1);
        main = createAccount.goMainPage();
        onixUiAssert.assertAll();
    }

    @Test
    public void footer() {
        Allure.link("Original test case", "https://docs.google.com/spreadsheets/d/1gudjZ7fh4aUsozP7aPIovLnI4qGdbUFpIHJ6AbTlbC4/edit#gid=633091546&range=B84");

        TermsOfService termsOfService = main.clickFooterTermsOfService();
        onixUiAssert.softCheckCountOfElementByLocator(TermsOfService.Locator.H4_TITLE, 1);
        CookiesPolicy cookiesPolicy = termsOfService.clickFooterCookiesPolicy();
        onixUiAssert.softCheckCountOfElementByLocator(CookiesPolicy.Locator.H4_TITLE, 1);
        PrivacyPolicy privacyPolicy = cookiesPolicy.clickFooterPrivatePolicy();
        onixUiAssert.softCheckCountOfElementByLocator(PrivacyPolicy.Locator.H4_TITLE, 1);
        ReportBugs reportBugs = privacyPolicy.clickFooterBugReports();
        onixUiAssert.softCheckCountOfElementByLocator(ReportBugs.Locator.H1_TITLE, 1);
        ContactUs contactUs = reportBugs.clickFooterContactUs();
        onixUiAssert.softCheckCountOfElementByLocator(ContactUs.Locator.H1_TITLE, 1);
        AccessAndDownload accessAndDownload = contactUs.clickFooterAccess();
        onixUiAssert.softCheckCountOfElementByLocator(AccessAndDownload.Locator.H4_TITLE, 1);
        Faqs faqs = accessAndDownload.clickFooterFAQs();
        onixUiAssert.softCheckCountOfElementByLocator(Faqs.Locator.H1_TITLE, 1);
        GooglePlayPage googlePlayPage = faqs.clickFooterPlayStore();
        onixUiAssert.softCheckCountOfElementByLocator(GooglePlayPage.Locator.GOOGLE_PLAY_LOGO, 1);
        faqs = new Faqs(googlePlayPage.backToJsa());
        AppStorePage appStorePage = faqs.clickFooterAppStore();
        onixUiAssert.softCheckCountOfElementByLocator(AppStorePage.Locator.APPLE_LOGO, 1);
        faqs = new Faqs(appStorePage.backToJsa());
        InstagramPage instagramPage = faqs.clickFooterInstagram();
        onixUiAssert.softCheckCountOfElementByLocator(InstagramPage.Locator.INSTAGRAM_LOGO, 1);
        faqs = new Faqs(instagramPage.closeAndBackToJsaTab());
        FacebookPage facebookPage = faqs.clickFooterFacebook();
        onixUiAssert.softCheckCountOfElementByLocator(FacebookPage.Locator.FACEBOOK_LOGO, 1);
        faqs = new Faqs(facebookPage.closeAndBackToJsaTab());
        SpotifyPage spotifyPage = faqs.clickFooterSpotify();
        onixUiAssert.softCheckUrlContains("spotify");
        main = new Faqs(spotifyPage.closeAndBackToJsaTab()).goMainPage();
        onixUiAssert.assertAll();
    }
}
