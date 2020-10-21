package ui.related_sites;

import org.openqa.selenium.By;
import ui.BasePageObject;
import ui.engine.OnixLocator;
import ui.engine.OnixWebDriver;

public class FacebookPage extends BasePageObject implements InAnotherTab {
    public FacebookPage(OnixWebDriver driver) {
        super(driver);
        driver.registerCurrentTab("facebook");
    }

    public enum Locator implements OnixLocator {
        FACEBOOK_LOGO(By.cssSelector("a[href='https://www.facebook.com/']")),
        JAMES_SMITH_H2(By.xpath("//h1//span[contains(text(), 'James Smith')]"))

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
