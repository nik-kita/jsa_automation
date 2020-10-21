package ui.related_sites;

import org.openqa.selenium.By;
import ui.BasePageObject;
import ui.engine.OnixLocator;
import ui.engine.OnixWebDriver;

public class InstagramPage extends BasePageObject implements InAnotherTab {
    public InstagramPage(OnixWebDriver driver) {
        super(driver);
        driver.registerCurrentTab("instagram");
    }




    public enum Locator implements OnixLocator {
        INSTAGRAM_LOGO(By.cssSelector("a[href='/'] img[alt='Instagram']")),

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
