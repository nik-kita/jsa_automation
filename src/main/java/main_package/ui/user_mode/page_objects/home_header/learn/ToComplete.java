package main_package.ui.user_mode.page_objects.home_header.learn;

import main_package.ui.BasePageObject;
import main_package.ui.engine.FlyTester;
import main_package.ui.engine.OnixLocator;
import main_package.ui.engine.OnixWebDriver;
import main_package.ui.user_mode.general_parts.home.HomeHeaderPart;
import org.openqa.selenium.By;

public class ToComplete extends BasePageObject implements HomeHeaderPart {

    public ToComplete(OnixWebDriver driver) {
        super(driver);
    }
    @Override
    public ToComplete test(FlyTester flyTester) {
        flyTester.test();
        return this;
    }

    public Learn clickBackArrow() {
        driver.findElement(Locator.BACK_ARROW).click();
        return new Learn(driver);
    }

    public enum Locator implements OnixLocator {
        H6_TITLE(By.xpath("//h6[text() = 'To Complete']")),
        BACK_ARROW(By.cssSelector(".back_link_arrow img")),

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
    public enum Locators implements OnixLocator {

        ;
        private By path;

        Locators(By path) {
            this.path = path;
        }

        @Override
        public By getPath() {
            return path;
        }
    }
}
