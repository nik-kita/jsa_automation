package ui.user_mode.page_objects.main.my_podcast;

import org.openqa.selenium.By;
import ui.BasePageObject;
import ui.engine.OnixLocator;
import ui.engine.OnixWebDriver;
import ui.user_mode.general_parts.Footer;
import ui.user_mode.general_parts.MainHeader;

public class PodcastEpisode extends BasePageObject implements Footer, MainHeader {
    public PodcastEpisode(OnixWebDriver driver) {
        super(driver);
    }
    public MyPodcast clickBackToMyPodcast() {
        driver.findElement(Locator.BACK_ARROW_LINK).click();
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
