package main_package.ui.___U_S_E_R___.page_objects.home_header.learn;

import main_package.ui.BasePageObject;
import main_package.engine.test_engine.FlyTester;
import main_package.engine.OnixLocator;
import main_package.engine.OnixWebDriver;
import main_package.ui.___U_S_E_R___.general_parts.home.HomeHeader;
import org.openqa.selenium.By;

public class ToComplete extends BasePageObject implements HomeHeader {

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