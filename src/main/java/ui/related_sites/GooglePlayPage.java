package ui.related_sites;

import org.openqa.selenium.By;
import ui.BasePageObject;
import ui.engine.OnixLocator;
import ui.engine.OnixWebDriver;

public class GooglePlayPage extends BasePageObject {
    public GooglePlayPage(OnixWebDriver driver) {
        super(driver);
    }
    public enum Locator implements OnixLocator {
        GOOGLE_PLAY_LOGO(By.xpath("//a[@title='Google Play Logo']")),
        JSA_TITLE(By.xpath("//h1//span[contains(text(), 'James Smith Academy')]"))
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
