package main_package.ui.related_sites;

import main_package.ui.engine.FlyTester;
import org.openqa.selenium.By;
import main_package.ui.BasePageObject;
import main_package.ui.engine.OnixLocator;
import main_package.ui.engine.OnixWebDriver;

public class SpotifyPage extends BasePageObject implements InAnotherTab {

    public SpotifyPage(OnixWebDriver driver) {
        super(driver);
    }
    @Override
    public SpotifyPage test(FlyTester flyTester) {
        flyTester.test();
        return this;
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
