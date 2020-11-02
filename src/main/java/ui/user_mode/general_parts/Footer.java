package ui.user_mode.general_parts;

import ui.engine.OnixWebDriver;
import ui.engine.OnixLocator;
import org.openqa.selenium.By;
import ui.BasePart;
import ui.user_mode.page_objects.from_footer.*;
import ui.user_mode.page_objects.from_footer.faqs.Faqs;


public interface Footer extends BasePart {

default Blog goBlogPageFromFooter() {
    OnixWebDriver driver = getDriver();
    driver.findElement(ui.guest_mode.general_parts.Footer.FooterLocator.BLOG_SUPPORT_LINK).click();
    getLogger().debug("'Blog' from footer");
    return new Blog(driver);
}
    default CookiesPolicy goCookiesPolicyFromFooter() {
        OnixWebDriver driver = getDriver();
        driver.findElement(ui.guest_mode.general_parts.Footer.FooterLocator.COOKIES_POLICY_LINK).click();
        getLogger().debug("'CookiesPolicy' from footer");
        return new CookiesPolicy(driver);
    }
    default PrivacyPolicy goPrivacyPolicyFromFooter() {
        OnixWebDriver driver = getDriver();
        driver.findElement(ui.guest_mode.general_parts.Footer.FooterLocator.PRIVACY_POLICY_LINK).click();
        getLogger().debug("'PrivacyPolicy' from footer");
        return new PrivacyPolicy(driver);
    }
    default TermsOfService goTermsOfServiceFromFooter() {
        OnixWebDriver driver = getDriver();
        driver.findElement(ui.guest_mode.general_parts.Footer.FooterLocator.TERMS_OF_SERVICE_LINK).click();
        getLogger().debug("'TermsOfService' from footer");
        return new TermsOfService(driver);
    }
    default ReportBugs goReportBugsFromFooter() {
        OnixWebDriver driver = getDriver();
        driver.findElement(ui.guest_mode.general_parts.Footer.FooterLocator.BUG_SUPPORT_LINK).click();
        getLogger().debug("'ReportBugs' from footer");
        return new ReportBugs(driver);
    }
    default ContactUs goContactUsFromFooter() {
        OnixWebDriver driver = getDriver();
        driver.findElement(ui.guest_mode.general_parts.Footer.FooterLocator.CONTACT_US_LINK).click();
        getLogger().debug("'ContactUs' from footer");
        return new ContactUs(driver);
    }
    default AccessAndDownload goAccessAndDownloadFromFooter() {
        OnixWebDriver driver = getDriver();
        driver.findElement(ui.guest_mode.general_parts.Footer.FooterLocator.ACCESS_LINK).click();
        getLogger().debug("'AccessAndDownload' from footer");
        return new AccessAndDownload(driver);
    }
    default Faqs goFaqsFromFooter() {
        OnixWebDriver driver = getDriver();
        driver.findElement(ui.guest_mode.general_parts.Footer.FooterLocator.FAQS_LINK).click();
        getLogger().debug("'Faqs' from footer");
        return new Faqs(driver);
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
