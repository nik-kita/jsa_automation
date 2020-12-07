package test_package.unit.user_mode.main.my_podcast;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.engine.test_engine.OnixUiAssert;
import main_package.engine.OnixLocator;
import main_package.ui.___U_S_E_R___.page_objects.main.my_podcast.PodcastEpisode;
import main_package.engine.test_engine.JsaLoginBaseUiTestRunner;

public class PodcastEpisodeUiTest extends JsaLoginBaseUiTestRunner {
    PodcastEpisode podcastEpisode;
    @BeforeClass
    public void goPodcastEpisode() {
        podcastEpisode = homeLoginModePO.goMainPage().goMyPodcastPageFromHeader().clickSomeoneEpisode();
    }
    @Test(dataProvider = "getPodcastEpisodeLocators")
    public void podcastEpisodeTest(OnixLocator locator) {
        new OnixUiAssert(driver).checkCountOfElementByLocator(locator, 1);
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