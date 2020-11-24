package main_package.ui.related_sites;

import main_package.ui.engine.FlyTester;
import org.openqa.selenium.By;
import main_package.ui.BasePageObject;
import main_package.ui.engine.OnixLocator;
import main_package.ui.engine.OnixWebDriver;

public class AppStorePage extends BasePageObject implements InCurrentTab {
    public AppStorePage(OnixWebDriver driver) {
        super(driver);
    }
    @Override
    public AppStorePage test(FlyTester flyTester) {
        flyTester.test();
        return this;
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
