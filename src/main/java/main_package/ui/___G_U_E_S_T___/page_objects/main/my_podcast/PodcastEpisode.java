package main_package.ui.___G_U_E_S_T___.page_objects.main.my_podcast;

import main_package.engine.test_engine.FlyTester;
import main_package.engine.test_engine.OnixUiAssert;
import org.openqa.selenium.By;
import main_package.ui.BasePageObject;
import main_package.engine.OnixLocator;
import main_package.engine.OnixWebDriver;
import main_package.ui.___G_U_E_S_T___.general_parts.Footer;
import main_package.ui.___G_U_E_S_T___.general_parts.MainHeader;

public class PodcastEpisode extends BasePageObject implements MainHeader, Footer {

    public PodcastEpisode(OnixWebDriver driver) {
        super(driver);
    }
    @Override
    public PodcastEpisode test(FlyTester flyTester) {
        flyTester.test();
        return this;
    }

    public MyPodcast clickBackToMyPodcast() {
        driver.findElement(Locator.BACK_ARROW_LINK).click();
        logger.debug("'MyPodcast' from 'PodcastEpisode'");
        return new MyPodcast(driver);
    }

    @Override
    public BasePageObject check(OnixUiAssert onixUiAssert) {
        for(OnixLocator l : OnixUiAssert.mergeArrays(
                PodcastEpisode.Locator.values()
                //TODO
        )){

        }
        return this;
    }

    public enum Locator implements OnixLocator {
        BACK_ARROW_LINK(By.cssSelector("[href='/podcasts/']")),
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