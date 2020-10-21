package ui.related_sites;

import org.openqa.selenium.By;
import ui.BasePageObject;
import ui.engine.OnixLocator;
import ui.engine.OnixWebDriver;

public class AppStorePage extends BasePageObject implements InCurrentTab {
    public AppStorePage(OnixWebDriver driver) {
        super(driver);
    }

    public enum Locator implements OnixLocator {
        APPLE_LOGO(By.xpath("//ul[contains(@class, 'list')]//a[@data-analytics-title='apple home']")),
        JSA_TITLE(By.xpath("//h1[contains(text(), 'James Smith Academy')]"))
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
