package main_package.ui.related_sites;

import main_package.ui.engine.FlyTester;
import main_package.ui.engine.OnixAssert;
import org.openqa.selenium.By;
import main_package.ui.BasePageObject;
import main_package.ui.engine.OnixLocator;
import main_package.ui.engine.OnixWebDriver;

public class GooglePlayPage extends BasePageObject implements InCurrentTab {
    public GooglePlayPage(OnixWebDriver driver) {
        super(driver);
    }
    @Override
    public GooglePlayPage test(FlyTester flyTester) {
        flyTester.test();
        return this;
    }

    public GooglePlayPage check(OnixAssert onixAssert) {
        for(OnixLocator l : GooglePlayPage.Locator.values()) {
            onixAssert.softCheckCountOfElementByLocator(l, 1);
        }
        return this;
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
