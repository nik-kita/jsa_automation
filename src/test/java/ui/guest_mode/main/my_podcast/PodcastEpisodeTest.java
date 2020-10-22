package ui.guest_mode.main.my_podcast;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ui.OnixAssert;
import ui.OnixTestRunner;
import ui.engine.OnixLocator;
import ui.guest_mode.page_objects.main.my_podcast.PodcastEpisode;

public class PodcastEpisodeTest extends OnixTestRunner {
    PodcastEpisode podcastEpisode;
    @BeforeClass
    public void goPodcastEpisode() {
        podcastEpisode = openSite().goMyPodcastPageFromHeader().clickSomeoneEpisode();
    }
    @Test(dataProvider = "getPodcastEpisodeLocators")
    public void podcastEpisodeTest(OnixLocator locator) {
        new OnixAssert(driver).checkCountOfElementByLocator(locator, 1);
    }
    @DataProvider
    public Object[] getPodcastEpisodeLocators() {
        return mergeArrays(
                PodcastEpisode.FooterLocator.values(),
                PodcastEpisode.HeaderLocator.values(),
                PodcastEpisode.Locator.values()
        );
    }
}