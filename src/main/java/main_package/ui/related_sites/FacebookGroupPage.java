package main_package.ui.related_sites;

import main_package.ui.BasePageObject;
import main_package.ui.engine.OnixLocator;
import main_package.ui.engine.OnixWebDriver;
import org.openqa.selenium.By;
import org.slf4j.Logger;

public class FacebookGroupPage extends BasePageObject implements InAnotherTab {

    public FacebookGroupPage(OnixWebDriver driver) {
        super(driver);
        driver.registerCurrentTab("facebookGroup");
        logger.debug("Open facebook group page in another tab");
    }

    @Override
    public Logger getLogger() {
        return logger;
    }

    @Override
    public OnixWebDriver getDriver() {
        return driver;
    }

    public enum Locator implements OnixLocator {
        JOIN_GROUP_BUTTON(By.cssSelector("div[aria-label='Join Group']")),
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
