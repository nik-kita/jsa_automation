package main_package.ui.guest_mode.main.my_podcast;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.engine.test_engine.OnixTestRunner;
import main_package.engine.OnixLocator;
import main_package.ui.guest_mode.page_objects.main.my_podcast.MyPodcast;


public class MyPodcastTest extends OnixTestRunner {
    MyPodcast myPodcast;
    @BeforeClass
    public void goMyPodcast() {
        myPodcast = openSite().goMyPodcastPageFromHeader();
    }
    @Test(dataProvider = "getMyPodcastLocators")
    public void myPodcastTest(OnixLocator locator) {
        onixUiAssert.checkCountOfElementByLocator(locator, 1);
    }
    @DataProvider
    public Object[] getMyPodcastLocators() {
        return mergeArrays(
                MyPodcast.FooterLocator.values(),
                MyPodcast.HeaderLocator.values(),
                MyPodcast.Locator.values()
        );
    }
}
