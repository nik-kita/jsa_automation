package main_package.ui.guest_mode.page_objects.main;


import main_package.engine.test_engine.FlyTester;
import main_package.engine.test_engine.OnixUiAssert;
import org.openqa.selenium.By;
import main_package.ui.BasePageObject;
import main_package.engine.OnixLocator;
import main_package.engine.OnixWebDriver;
import main_package.ui.guest_mode.general_parts.Footer;
import main_package.ui.guest_mode.general_parts.MainHeader;
import main_package.ui.guest_mode.page_objects.main.login.CreateAccount;
import main_package.ui.related_sites.AppStorePage;
import main_package.ui.related_sites.FacebookPage;
import main_package.ui.related_sites.GooglePlayPage;
import main_package.ui.related_sites.InstagramPage;

public class Main extends BasePageObject implements Footer, MainHeader {

    public Main(OnixWebDriver driver) {
        super(driver);
        logger.debug("'Main' page is open.");
    }
    public Main(OnixWebDriver driver, OnixUiAssert onixUiAssert) {
        super(driver);
        check(onixUiAssert);
    }
    @Override
    public Main test(FlyTester flyTester) {
        flyTester.test();
        return this;
    }

    public CreateAccount clickGetStartedButton() {
        driver.findElement(Locator.GET_STARTED_BUTTON).click();
        logger.info("Click 'Get started - it's free' button from main page");
        return new CreateAccount(driver);
    }

    public Main check(OnixUiAssert onixUiAssert) {
        for(OnixLocator l : OnixUiAssert.mergeArrays(
                Main.Locator.values(),
                MainHeader.HeaderLocator.values(),
                Footer.FooterLocator.values()
        )) {
            onixUiAssert.softCheckCountOfElementByLocator(l, 1);
        }
        return this;
    }
    public CreateAccount clickGetStartedButton(OnixUiAssert onixUiAssert) {
        driver.findElement(Locator.GET_STARTED_BUTTON).click();
        logger.info("Click 'Get started - it's free' button from main page");
        return new CreateAccount(driver).check(onixUiAssert);
    }

    public GooglePlayPage clickPlayStoreBannerButton() {
        driver.findElement(Locator.PLAY_STORE_BUTTON_BANNER).click();
        logger.info("Click 'Play Store' button.");
        return new GooglePlayPage(driver);
    }

    public GooglePlayPage clickPlayStoreBannerButton(OnixUiAssert onixUiAssert) {
        driver.findElement(Locator.PLAY_STORE_BUTTON_BANNER).click();
        logger.info("Click 'Play Store' button.");
        return new GooglePlayPage(driver).check(onixUiAssert);
    }
    public GooglePlayPage clickPlayStoreButtonInDownloadSection() {
        driver.findElement(Locator.PLAY_STORE_BUTTON_DOWNLOAD).click();
        logger.info("Click 'Play Store' button in download section.");
        return new GooglePlayPage(driver);
    }
    public GooglePlayPage clickPlayStoreButtonInDownloadSection(OnixUiAssert onixUiAssert) {
        return clickPlayStoreButtonInDownloadSection().check(onixUiAssert);
    }

    public AppStorePage clickAppStoreBannerButton() {
        driver.findElement(Locator.APPSTORE_BUTTON_BANNER).click();
        logger.info("Click 'App Store' button.");
        return new AppStorePage(driver);
    }
    public AppStorePage clickAppStoreBannerButton(OnixUiAssert onixUiAssert) {
        driver.findElement(Locator.APPSTORE_BUTTON_BANNER).click();
        logger.info("Click 'App Store' button.");
        return new AppStorePage(driver).check(onixUiAssert);
    }
    public AppStorePage clickAppStoreButtonInDownloadSection() {
        driver.findElement(Locator.APPSTORE_BUTTON_DOWNLOAD).click();
        logger.info("Click 'App Store' button in download section.");
        return new AppStorePage(driver);
    }
    public AppStorePage clickAppStoreButtonInDownloadSection(OnixUiAssert onixUiAssert) {
        return clickAppStoreButtonInDownloadSection().check(onixUiAssert);
    }
    public InstagramPage clickMyInstagramBannerButton() {
        driver.findElement(Locator.INSTAGRAM_BUTTON_INTRODUCTION).click();
        driver.switchAnotherTab("jsa");
        logger.debug("Click 'My Instagram' button.");
        return new InstagramPage(driver);
    }
    public InstagramPage clickMyInstagramBannerButton(OnixUiAssert onixUiAssert) {
        return clickMyInstagramBannerButton().check(onixUiAssert);
    }
    public FacebookPage clickMyFacebookBannerButton() {
        driver.findElement(Locator.FACEBOOK_BUTTON_INTRODUCTION).click();
        driver.switchAnotherTab("jsa");
        logger.info("Click 'My Facebook' button.");
        return new FacebookPage(driver);
    }
    public FacebookPage clickMyFacebookBannerButton(OnixUiAssert onixUiAssert) {
        return clickMyFacebookBannerButton().check(onixUiAssert);
    }
    public Challenge clickAboutChallengesButton() {
        driver.findElement(Locator.ABOUT_CHALLENGES_MOTIVATION).click();
        logger.info("Click 'About Challenges' button.");
        return new Challenge(driver);
    }
    public Challenge clickAboutChallengesButton(OnixUiAssert onixUiAssert) {
        return clickAboutChallengesButton().check(onixUiAssert);
    }
    public Transformations clickSeeMoreTransformationsButton() {
        driver.findElement(Locator.TRANSFORMATIONS_BUTTON_MEMBER_TRANSFORMATIONS).click();
        logger.info("Click 'See More Transformations' button.");
        return new Transformations(driver);
    }
    public Transformations clickSeeMoreTransformationsButton(OnixUiAssert onixUiAssert) {
        return clickSeeMoreTransformationsButton().check(onixUiAssert);
    }

    public FamousDailyEmails cheaterClickFamousDailyEmail() {
        String fakeEmail = "fakeEmail@gmail.com";
        String script = "document.querySelector(\"button[type='submit']\").removeAttribute(\"disabled\")";
        driver.findElement(Locator.EMAIL_INPUT_DAILY_EMAILS).sendKeys(fakeEmail);
        driver.executeJsScript(script);
        driver.findElement(Locator.SIGN_UP_DAILY_EMAILS).click();
        logger.info("Click 'Sign up' button in 'Famous Daily Emails' section.");
        logger.warn("Use cheater way to click 'input' button under the 'daily famous emails' because of captcha.");
        return new FamousDailyEmails(driver);
    }

    public FamousDailyEmails cheaterClickFamousDailyEmail(OnixUiAssert onixUiAssert) {
        return cheaterClickFamousDailyEmail().check(onixUiAssert);
    }


    public enum Locator implements OnixLocator {
        GET_STARTED_BUTTON(By.cssSelector(".banner a[href='/users/register/']")),
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
