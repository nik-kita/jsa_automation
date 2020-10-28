package ui.user_mode.main.my_podcast;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ui.OnixAssert;
import ui.OnixTestRunner;
import ui.engine.OnixLocator;
import ui.user_mode.page_objects.main.my_podcast.MyPodcast;
import ui.user_mode.JsaLoginBaseTestRunner;


public class MyPodcastTest extends JsaLoginBaseTestRunner {
    MyPodcast myPodcast;
    @BeforeClass
    public void goMyPodcast() {
        myPodcast = homeLoginModePO.goMainPage().goMyPodcastPageFromHeader();
    }
    @Test(dataProvider = "getMyPodcastLocators")
    public void myPodcastTest(OnixLocator locator) {
        onixAssert.checkCountOfElementByLocator(locator, 1);
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
