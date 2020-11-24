package main_package.ui.user_mode.page_objects.main;


import main_package.ui.engine.FlyTester;
import org.openqa.selenium.By;
import main_package.ui.BasePageObject;
import main_package.ui.engine.OnixLocator;
import main_package.ui.engine.OnixWebDriver;
import main_package.ui.related_sites.AppStorePage;
import main_package.ui.related_sites.FacebookPage;
import main_package.ui.related_sites.GooglePlayPage;
import main_package.ui.related_sites.InstagramPage;
import main_package.ui.user_mode.general_parts.Footer;
import main_package.ui.user_mode.general_parts.MainHeader;

public class Main extends BasePageObject implements Footer, MainHeader {

    public Main(OnixWebDriver driver) {
        super(driver);
    }
    @Override
    public Main test(FlyTester flyTester) {
        flyTester.test();
        return this;
    }
    public GooglePlayPage clickPlayStoreBannerButton() {
        driver.findElement(Locator.PLAY_STORE_BUTTON_BANNER).click();
        logger.debug("'GooglePlayPage' from 'Main'");
        return new GooglePlayPage(driver);
    }
    public GooglePlayPage clickPlayStoreButtonInDownloadSection() {
        driver.findElement(Locator.PLAY_STORE_BUTTON_DOWNLOAD).click();
        logger.debug("'GooglePlayPage' from 'Main'");
        return new GooglePlayPage(driver);
    }
    public AppStorePage clickAppStoreBannerButton() {
        driver.findElement(Locator.APPSTORE_BUTTON_BANNER).click();
        logger.debug("'AppStorePage' from 'Main'");
        return new AppStorePage(driver);
    }
    public AppStorePage clickAppStoreButtonInDownloadSection() {
        driver.findElement(Locator.APPSTORE_BUTTON_DOWNLOAD).click();
        logger.debug("'AppStorePage' from 'Main'");
        return new AppStorePage(driver);
    }
    public InstagramPage clickMyInstagramBannerButton() {
        driver.findElement(Locator.INSTAGRAM_BUTTON_INTRODUCTION).click();
        driver.switchAnotherTab("jsa");
        logger.debug("'InstagramPage' from 'Main'");
        return new InstagramPage(driver);
    }
    public FacebookPage clickFacebookBannerButton() {
        driver.findElement(Locator.FACEBOOK_BUTTON_INTRODUCTION).click();
        driver.switchAnotherTab("jsa");
        logger.debug("'FacebookPge' from 'Main'");
        return new FacebookPage(driver);
    }
    public Challenge clickAboutChallengesButton() {
        driver.findElement(Main.Locator.ABOUT_CHALLENGES_MOTIVATION).click();
        logger.debug("'Challenge' from 'Main'");
        return new Challenge(driver);
    }
    public Transformations clickSeeMoreTransformationsButton() {
        driver.findElement(Locator.TRANSFORMATIONS_BUTTON_MEMBER_TRANSFORMATIONS).click();
        logger.debug("'Transformations' from 'Main'");
        return new Transformations(driver);
    }
    public FamousDailyEmails cheaterClickFamousDailyEmail() {
        String fakeEmail = "fakeEmail@gmail.com";
        String script = "document.querySelector(\"button[type='submit']\").removeAttribute(\"disabled\")";
        driver.findElement(Locator.EMAIL_INPUT_DAILY_EMAILS).sendKeys(fakeEmail);
        driver.executeJsScript(script);
        driver.findElement(Locator.SIGN_UP_DAILY_EMAILS).click();
        logger.debug("cheater way to 'FamousDailyEmails' from 'Main'");
        return new FamousDailyEmails(driver);
    }


    public enum Locator implements OnixLocator {
        GET_STARTED_BUTTON_BANNER(By.cssSelector(".banner a[href='/users/register/']")),
        PLAY_STORE_BUTTON_BANNER(By.cssSelector(".banner img[alt='playstore']")),
        APPSTORE_BUTTON_BANNER(By.cssSelector(".banner img[alt='appstore']")),
        INSTAGRAM_BUTTON_INTRODUCTION(By.cssSelector(".introduction .insta")),
        PLAY_STORE_BUTTON_DOWNLOAD(By.cssSelector(".download img[alt='playstore']")),
        FACEBOOK_BUTTON_INTRODUCTION(By.cssSelector(".introduction .facebook")),
        APPSTORE_BUTTON_DOWNLOAD(By.cssSelector(".download img[alt='appstore']")),
        ABOUT_CHALLENGES_MOTIVATION(By.cssSelector(".motivation [href='/challenge/about/']")),
        TRANSFORMATIONS_BUTTON_MEMBER_TRANSFORMATIONS(By.cssSelector(".member_transformations [href='/transformations/']")),
        EMAIL_INPUT_DAILY_EMAILS(By.cssSelector("input[name='email']")),
        SIGN_UP_DAILY_EMAILS(By.cssSelector("#daily-button")),


        ;

        Locator(By path) {
            this.path = path;
        }

        private By path;

        @Override
        public By getPath() {
            return path;
        }

    }

}
