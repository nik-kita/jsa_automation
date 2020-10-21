package ui.guest_mode.general_parts;

import org.openqa.selenium.By;
import ui.BasePart;
import ui.engine.OnixLocator;
import ui.engine.OnixWebDriver;
import ui.guest_mode.page_objects.from_footer.Blog;
import ui.guest_mode.page_objects.from_footer.*;


public interface Footer extends BasePart {

    default Blog goBlogPageFromFooter() {
        OnixWebDriver driver = getDriver();
        driver.findElement(FooterLocator.BLOG_SUPPORT_LINK).click();
        return new Blog(driver);
    }
    default CookiesPolicy goCookiesPolicyFromFooter() {
        OnixWebDriver driver = getDriver();
        driver.findElement(FooterLocator.COOKIES_POLICY_LINK).click();
        return new CookiesPolicy(driver);
    }
    default PrivacyPolicy goPrivacyPolicyFromFooter() {
        OnixWebDriver driver = getDriver();
        driver.findElement(FooterLocator.PRIVACY_POLICY_LINK).click();
        return new PrivacyPolicy(driver);
    }
    default TermsOfService goTermsOfServiceFromFooter() {
        OnixWebDriver driver = getDriver();
        driver.findElement(FooterLocator.TERMS_OF_SERVICE_LINK).click();
        return new TermsOfService(driver);
    }
    default ReportBugs goReportBugsFromFooter() {
        OnixWebDriver driver = getDriver();
        driver.findElement(FooterLocator.BUG_SUPPORT_LINK).click();
        return new ReportBugs(driver);
    }
    default ContactUs goContactUsFromFooter() {
        OnixWebDriver driver = getDriver();
        driver.findElement(FooterLocator.CONTACT_US_LINK).click();
        return new ContactUs(driver);
    }
    default AccessAndDowload goAccessAndDownloadFromFooter() {
        OnixWebDriver driver = getDriver();
        driver.findElement(FooterLocator.ACCESS_LINK).click();
        return new AccessAndDowload(driver);
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
