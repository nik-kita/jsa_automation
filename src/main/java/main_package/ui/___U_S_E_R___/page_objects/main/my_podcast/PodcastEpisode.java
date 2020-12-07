package main_package.ui.___U_S_E_R___.page_objects.main.my_podcast;

import main_package.engine.test_engine.FlyTester;
import org.openqa.selenium.By;
import main_package.ui.BasePageObject;
import main_package.engine.OnixLocator;
import main_package.engine.OnixWebDriver;
import main_package.ui.___U_S_E_R___.general_parts.Footer;
import main_package.ui.___U_S_E_R___.general_parts.MainHeader;

public class PodcastEpisode extends BasePageObject implements Footer, MainHeader {

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
