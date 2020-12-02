package test_package.unit.guest_mode.main.my_podcast;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.engine.test_engine.OnixUiTestRunner;
import main_package.engine.OnixLocator;
import main_package.ui.guest_mode.page_objects.main.my_podcast.PodcastEpisode;

public class PodcastEpisodeUiTest extends OnixUiTestRunner {
    PodcastEpisode podcastEpisode;
    @BeforeClass
    public void goPodcastEpisode() {
        podcastEpisode = openSite().goMyPodcastPageFromHeader().clickSomeoneEpisode();
    }
    @Test(dataProvider = "getPodcastEpisodeLocators")
    public void podcastEpisodeTest(OnixLocator locator) {
        onixUiAssert.checkCountOfElementByLocator(locator, 1);
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