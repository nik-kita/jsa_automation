package test_package.unit.user_mode.main.my_podcast;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.engine.OnixLocator;
import main_package.ui.___U_S_E_R___.page_objects.main.my_podcast.MyPodcast;
import main_package.engine.test_engine.JsaLoginBaseUiTestRunner;


public class MyPodcastUiTest extends JsaLoginBaseUiTestRunner {
    MyPodcast myPodcast;
    @BeforeClass
    public void goMyPodcast() {
        myPodcast = homeLoginModePO.goMainPage().goMyPodcastPageFromHeader();
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
