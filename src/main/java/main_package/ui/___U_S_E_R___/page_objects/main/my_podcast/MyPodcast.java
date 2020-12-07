package main_package.ui.___U_S_E_R___.page_objects.main.my_podcast;

import main_package.engine.test_engine.FlyTester;
import org.openqa.selenium.By;
import main_package.ui.BasePageObject;
import main_package.engine.OnixLocator;
import main_package.engine.OnixWebDriver;
import main_package.ui.___U_S_E_R___.general_parts.Footer;
import main_package.ui.___U_S_E_R___.general_parts.MainHeader;

public class MyPodcast extends BasePageObject implements MainHeader, Footer {

    public MyPodcast(OnixWebDriver driver) {
        super(driver);
    }
    @Override
    public MyPodcast test(FlyTester flyTester) {
        flyTester.test();
        return this;
    }
    OnixLocator oneEpisodeLocator = makeOnixLocator(By.cssSelector(".content .podcast_image"), this.getClass());

    public PodcastEpisode clickEpisodeContains(String partOfTheEpisodeName) {
        OnixLocator uniqueEpisode = makeOnixLocator(By.xpath("//div[@class='content']//a[contains(text(), '" + partOfTheEpisodeName + "')]"), this.getClass());
        driver.findElement(uniqueEpisode).click();
        logger.debug("'PodcastEpisode' from 'MyPodcast' that contains '" + partOfTheEpisodeName + "' word in name");
        return new PodcastEpisode(driver);
    }
    public PodcastEpisode clickSomeoneEpisode() {
        driver.findElement(oneEpisodeLocator).click();
        logger.debug("'PodcastEpisode' from 'MyPodcast'");
        return new PodcastEpisode(driver);
    }

    public enum Locator implements OnixLocator {
        APPLE_PODCASTS_LINK(By.xpath("//a[contains(@href, 'podcasts.apple')]")),
        SPOTIFY_LINK(By.xpath("//a[contains(@href, 'open.spotify')]")),
        YOUTUBE_LINK(By.xpath("//div[@class='buttons']//a[contains(@href, 'youtube')]")),
        SHARE_LINK_CHAIN_IMAGE(By.xpath("//div[@class='item']//img[contains(@src, 'ic_url')]")),
        FACEBOOK_SHARE_LINK(By.xpath("//div[@class='item']//img[contains(@src, 'ic_facebook')]")),
        TWITTER_SHARE_LINK(By.xpath("//div[@class='item']//img[contains(@src, 'ic_twitter')]")),

        ;
        private By path;
        Locator(By path) {
            this.path = path;
        }
        @Override
        public By getPath() {
            return path;
        }
    }
}
