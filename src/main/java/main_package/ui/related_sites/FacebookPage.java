package main_package.ui.related_sites;

import main_package.engine.test_engine.FlyTester;
import main_package.engine.test_engine.OnixUiAssert;
import org.openqa.selenium.By;
import main_package.ui.BasePageObject;
import main_package.engine.OnixLocator;
import main_package.engine.OnixWebDriver;

public class FacebookPage extends BasePageObject implements InAnotherTab {
    public FacebookPage(OnixWebDriver driver) {
        super(driver);
        logger.debug("'Facebook' page is open.");
        driver.registerCurrentTab("facebook");
    }
    public FacebookPage check(OnixUiAssert onixUiAssert) {
        for(OnixLocator l : FacebookPage.Locator.values()) {
            onixUiAssert.softCheckCountOfElementByLocator(l, 1);
        }
        return this;
    }
    @Override
    public FacebookPage test(FlyTester flyTester) {
        flyTester.test();
        return this;
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
