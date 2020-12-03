package main_package.ui.related_sites;

import main_package.engine.test_engine.FlyTester;
import main_package.engine.test_engine.OnixUiAssert;
import org.openqa.selenium.By;
import main_package.ui.BasePageObject;
import main_package.engine.OnixLocator;
import main_package.engine.OnixWebDriver;

public class InstagramPage extends BasePageObject implements InAnotherTab {
    public InstagramPage(OnixWebDriver driver) {
        super(driver);
        logger.debug("'Instagram' page is open.");
        driver.registerCurrentTab("instagram");
    }
    @Override
    public InstagramPage test(FlyTester flyTester) {
        flyTester.test();
        return this;
    }

    public InstagramPage check(OnixUiAssert onixUiAssert) {
        for(OnixLocator l : onixUiAssert.mergeArrays(
                InstagramPage.Locator.values()
        )) {
            onixUiAssert.softCheckCountOfElementByLocator(l, 1);
        }
        return this;
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
