package main_package.ui.related_sites;

import main_package.ui.engine.FlyTester;
import org.openqa.selenium.By;
import main_package.ui.BasePageObject;
import main_package.ui.engine.OnixLocator;
import main_package.ui.engine.OnixWebDriver;

public class InstagramPage extends BasePageObject implements InAnotherTab {
    public InstagramPage(OnixWebDriver driver) {
        super(driver);
        driver.registerCurrentTab("instagram");
    }
    @Override
    public InstagramPage test(FlyTester flyTester) {
        flyTester.test();
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
