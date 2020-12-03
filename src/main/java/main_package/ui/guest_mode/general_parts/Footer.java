package main_package.ui.guest_mode.general_parts;

import main_package.engine.test_engine.OnixUiAssert;
import org.openqa.selenium.By;
import main_package.ui.BasePart;
import main_package.engine.OnixLocator;
import main_package.engine.OnixWebDriver;
import main_package.ui.guest_mode.page_objects.from_footer.Blog;
import main_package.ui.guest_mode.page_objects.from_footer.*;
import main_package.ui.guest_mode.page_objects.from_footer.faqs.Faqs;
import main_package.ui.related_sites.*;


public interface Footer extends BasePart {

    default Blog clickFooterBlog() {
        OnixWebDriver driver = getDriver();
        driver.findElement(FooterLocator.BLOG_SUPPORT_LINK).click();
        getLogger().info("Click 'Blog' button in footer 'Support' section.");
        return new Blog(driver);
    }
    default Blog clickFooterBlog(OnixUiAssert onixUiAssert) {
        return clickFooterBlog().check(onixUiAssert);
    }
    default CookiesPolicy clickFooterCookiesPolicy() {
        OnixWebDriver driver = getDriver();
        driver.findElement(FooterLocator.COOKIES_POLICY_LINK).click();
        getLogger().info("Click 'Cookies Policy' button in footer 'Company' section.");
        return new CookiesPolicy(driver);
    }
    default CookiesPolicy clickFooterCookiesPolicy(OnixUiAssert onixUiAssert) {
        return clickFooterCookiesPolicy().check(onixUiAssert);
    }
    default PrivacyPolicy clickFooterPrivatePolicy() {
        OnixWebDriver driver = getDriver();
        driver.findElement(FooterLocator.PRIVACY_POLICY_LINK).click();
        getLogger().info("Click 'Privacy Policy' button in footer 'Company' section.");
        return new PrivacyPolicy(driver);
    }
    default PrivacyPolicy clickFooterPrivatePolicy(OnixUiAssert onixUiAssert) {
        return clickFooterPrivatePolicy().check(onixUiAssert);
    }
    default TermsOfService clickFooterTermsOfService() {
        OnixWebDriver driver = getDriver();
        driver.findElement(FooterLocator.TERMS_OF_SERVICE_LINK).click();
        getLogger().info("Click 'Terms Of Service' button in footer 'Company' section.");
        return new TermsOfService(driver);
    }
    default TermsOfService clickFooterTermsOfService(OnixUiAssert onixUiAssert) {
        return clickFooterTermsOfService().check(onixUiAssert);
    }
    default ReportBugs clickFooterBugReports() {
        OnixWebDriver driver = getDriver();
        driver.findElement(FooterLocator.BUG_SUPPORT_LINK).click();
        getLogger().info("Click 'Bug Reports' button in footer 'Support' section.");
        return new ReportBugs(driver);
    }
    default ReportBugs clickFooterBugReports(OnixUiAssert onixUiAssert) {
        return clickFooterBugReports().check(onixUiAssert);
    }
    default ContactUs clickFooterContactUs() {
        OnixWebDriver driver = getDriver();
        driver.findElement(FooterLocator.CONTACT_US_LINK).click();
        getLogger().debug("Click 'Contact Us' button in footer 'Support' section.");
        return new ContactUs(driver);
    }
    default ContactUs clickFooterContactUs(OnixUiAssert onixUiAssert) {
        return clickFooterContactUs().check(onixUiAssert);
    }
    default AccessAndDownload clickFooterAccess() {
        OnixWebDriver driver = getDriver();
        driver.findElement(FooterLocator.ACCESS_LINK).click();
        getLogger().info("Click 'Access' button in footer 'Support' section.");
        return new AccessAndDownload(driver);
    }
    default AccessAndDownload clickFooterAccess(OnixUiAssert onixUiAssert) {
        return clickFooterAccess().check(onixUiAssert);
    }
    default Faqs clickFooterFAQs() {
        OnixWebDriver driver = getDriver();
        driver.findElement(FooterLocator.FAQS_LINK).click();
        getLogger().info("Click 'FAQS' button in footer 'Support' section.");
        return new Faqs(driver);
    }
    default Faqs clickFooterFAQs(OnixUiAssert onixUiAssert) {
        return clickFooterFAQs().check(onixUiAssert);
    }


    default GooglePlayPage clickFooterPlayStore() {
        OnixWebDriver driver = getDriver();
        driver.findElement(FooterLocator.PLAY_STORE_BUTTON).click();
        getLogger().info("Click 'Play Store' button in footer 'Download our app' section.");
        return new GooglePlayPage(driver);
    }
    default GooglePlayPage clickFooterPlayStore(OnixUiAssert onixUiAssert) {
        return clickFooterPlayStore().check(onixUiAssert);
    }

    default AppStorePage clickFooterAppStore() {
        OnixWebDriver driver = getDriver();
        driver.findElement(FooterLocator.APPSTORE_BUTTON).click();
        getLogger().info("Click 'App Store' button in footer 'Download our app' section.");
        return new AppStorePage(driver);
    }
    default AppStorePage clickFooterAppStore(OnixUiAssert onixUiAssert) {
        return clickFooterAppStore().check(onixUiAssert);
    }

    default FacebookPage clickFooterFacebook() {
        OnixWebDriver driver = getDriver();
        driver.findElement(FooterLocator.FACEBOOK_LINK).click();
        driver.switchAnotherTab("jsa");
        getLogger().info("Click 'Facebook' button in footer 'Social media' section.");
        return new FacebookPage(driver);
    }
    default FacebookPage clickFooterFacebook(OnixUiAssert onixUiAssert) {
        return clickFooterFacebook().check(onixUiAssert);
    }

    default InstagramPage clickFooterInstagram() {
        OnixWebDriver driver = getDriver();
        driver.findElement(FooterLocator.INSTAGRAM_LINK).click();
        driver.switchAnotherTab("jsa");
        getLogger().info("Click 'Instagram' button in footer 'Social media' section.");
        return new InstagramPage(driver);
    }
    default InstagramPage clickFooterInstagram(OnixUiAssert onixUiAssert) {
        return clickFooterInstagram().check(onixUiAssert);
    }

    default SpotifyPage clickFooterSpotify() {
        OnixWebDriver driver = getDriver();
        driver.findElement(FooterLocator.SPOTIFY_PLAYLIST_LINK).click();
        driver.switchAnotherTab("jsa");
        getLogger().info("Click 'Spotify' button in footer 'Social media' section.");
        return new SpotifyPage(driver);
    }
    default SpotifyPage clickFooterSpotify(OnixUiAssert onixUiAssert) {
        return clickFooterSpotify().check(onixUiAssert);
    }




    OnixWebDriver getDriver();

    enum FooterLocator implements OnixLocator {
        JSA_LOGO(By.cssSelector("footer .logo")),
        TERMS_OF_SERVICE_LINK(By.cssSelector(".company [href='/terms/']")),
        COOKIES_POLICY_LINK(By.cssSelector(".company [href='/cookies-policy/']")),
        PRIVACY_POLICY_LINK(By.cssSelector(".company [href='/privacy/']")),
        BLOG_SUPPORT_LINK(By.xpath("//footer//div[@class='support']//a[contains(text(), 'Blog')]")),
        BUG_SUPPORT_LINK(By.cssSelector(".support [href='/emails/bug-report/']")),
        CONTACT_US_LINK(By.cssSelector(".support [href='/emails/contact-us/']")),
        ACCESS_LINK(By.cssSelector(".support [href='/access/']")),
        FAQS_LINK(By.cssSelector(".support [href='/faqs/']")),
        PLAY_STORE_BUTTON(By.cssSelector("#website-footer img[alt='playstore']")),
        APPSTORE_BUTTON(By.cssSelector("#website-footer img[alt='appstore']")),
        FACEBOOK_LINK(By.cssSelector("#website-footer [alt='ic_facebook']")),
        INSTAGRAM_LINK(By.cssSelector("[alt='ic_instagram']")),
        SPOTIFY_PLAYLIST_LINK(By.cssSelector("#website-footer [alt='ic_spotify']")),

        ;

        FooterLocator(By path) {
            this.path = path;
        }

        private By path;

        @Override
        public By getPath() {
            return path;
        }
    }

}
