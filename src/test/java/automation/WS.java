package automation;

import io.qameta.allure.Allure;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.TestInstance;
import org.testng.asserts.SoftAssert;
import ui.OnixAssert;
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

public class WS extends OnixTestRunner {
    Main main;

    @BeforeClass
    public void startFromMainPage() {
        main = openSite();
    }

    @Test(testName = "Pricing")
    public void test_1() throws FileNotFoundException {
        allureAddMarkdownDescriptionFromFile("pricing.md");
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

    @Test(testName = "Transformations")
    public void test_2() {
        allureAddTxtFileAttachment("transformations.txt");
        Transformations transformations = main
                .clickSeeMoreTransformationsButton();
        int before = Integer.MIN_VALUE;
        while (transformations.seeMore()) {
            int current = transformations.countTransformations();
            onixAssert.softCheckFirstGreaterSecond(current, before);
            System.out.println(before + "  " + current);
            before = current;
        }
        main = transformations.goMainPage();
        onixAssert.assertAll();
    }

    @Test(testName = "Blog")
    public void test_3() {
        Allure.link("Test Case in Google Sheets","https://docs.google.com/spreadsheets/d/1gudjZ7fh4aUsozP7aPIovLnI4qGdbUFpIHJ6AbTlbC4/edit#gid=633091546&range=B40");
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

    @Test(testName = "Login")
    public void test_4() {
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

    @Test(testName = "Footer")
    public void test_5() {
        Allure.link("Test case", "https://docs.google.com/spreadsheets/d/1gudjZ7fh4aUsozP7aPIovLnI4qGdbUFpIHJ6AbTlbC4/edit#gid=633091546&range=B84");
        allureAddMarkdownDescription("" +
                "### Check every link in main footer of the site\n" +
                "> Because this footer is general part of big amount of pages\n" +
                "> it is simply open every of them and without go back\n" +
                "> to previous open next footer link.\n" +
                "> If link redirect to another site suck Facebook etc.\n" +
                "> the test is close new tab or click to go back");
        Allure.step("1");
        TermsOfService termsOfService = main.goTermsOfServiceFromFooter();
        onixAssert.softCheckCountOfElementByLocator(TermsOfService.Locator.H4_TITLE, 1);
        Allure.step("2");
        CookiesPolicy cookiesPolicy = termsOfService.goCookiesPolicyFromFooter();
        onixAssert.softCheckCountOfElementByLocator(CookiesPolicy.Locator.H4_TITLE, 1);
        Allure.step("3");
        PrivacyPolicy privacyPolicy = cookiesPolicy.goPrivacyPolicyFromFooter();
        onixAssert.softCheckCountOfElementByLocator(PrivacyPolicy.Locator.H4_TITLE, 1);
        Allure.step("4");
        ReportBugs reportBugs = privacyPolicy.goReportBugsFromFooter();
        onixAssert.softCheckCountOfElementByLocator(ReportBugs.Locator.H1_TITLE, 1);
        Allure.step("5");
        ContactUs contactUs = reportBugs.goContactUsFromFooter();
        onixAssert.softCheckCountOfElementByLocator(ContactUs.Locator.H1_TITLE, 1);
        Allure.step("6");
        AccessAndDownload accessAndDownload = contactUs.goAccessAndDownloadFromFooter();
        onixAssert.softCheckCountOfElementByLocator(AccessAndDownload.Locator.H4_TITLE, 1);
        Allure.step("7");
        Faqs faqs = accessAndDownload.goFaqsFromFooter();
        onixAssert.softCheckCountOfElementByLocator(Faqs.Locator.H1_TITLE, 1);
        Allure.step("8");
        GooglePlayPage googlePlayPage = faqs.downloadAppPlayStoreFromFooter();
        onixAssert.softCheckCountOfElementByLocator(GooglePlayPage.Locator.GOOGLE_PLAY_LOGO, 1);
        faqs = new Faqs(googlePlayPage.backToJsa());
        Allure.step("9");
        AppStorePage appStorePage = faqs.downloadAppAppStoreFromFooter();
        onixAssert.softCheckCountOfElementByLocator(AppStorePage.Locator.APPLE_LOGO, 1);
        faqs = new Faqs(appStorePage.backToJsa());
        Allure.step("10");
        InstagramPage instagramPage = faqs.clickInstagramFromFooter();
        onixAssert.softCheckCountOfElementByLocator(InstagramPage.Locator.INSTAGRAM_LOGO, 1);
        faqs = new Faqs(instagramPage.closeAndBackToJsaTab());
        Allure.step("11");
        FacebookPage facebookPage = faqs.clickFacebookFromFooter();
        onixAssert.softCheckCountOfElementByLocator(FacebookPage.Locator.FACEBOOK_LOGO, 1);
        faqs = new Faqs(facebookPage.closeAndBackToJsaTab());
        Allure.step("12");
        SpotifyPage spotifyPage = faqs.clickSpotifyFromFooter();
        onixAssert.softCheckUrlContains("spotify");
        main = new Faqs(spotifyPage.closeAndBackToJsaTab()).goMainPage();
        onixAssert.assertAll();
    }
}
