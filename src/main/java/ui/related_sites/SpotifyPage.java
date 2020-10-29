package ui.related_sites;

import org.openqa.selenium.By;
import ui.BasePageObject;
import ui.engine.OnixLocator;
import ui.engine.OnixWebDriver;

public class SpotifyPage extends BasePageObject implements InAnotherTab {

    public SpotifyPage(OnixWebDriver driver) {
        super(driver);
    }

    public enum Locator implements OnixLocator {


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
