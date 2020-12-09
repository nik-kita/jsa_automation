package main_package.ui.___U_S_E_R___.page_objects.home_header.home;

import main_package.engine.test_engine.FlyTester;
import org.openqa.selenium.By;
import main_package.ui.BasePageObject;
import main_package.engine.OnixLocator;
import main_package.engine.OnixWebDriver;
import main_package.ui.___U_S_E_R___.general_parts.home.HomeHeader;

public class Challenges extends BasePageObject implements HomeHeader {
    public Challenges(OnixWebDriver driver) {
        super(driver);
    }
    @Override
    public Challenges test(FlyTester flyTester) {
        flyTester.test();
        return this;
    }

    public Home clickBackArrow() {
        driver.findElement(Locator.BACK_HOME_ARROW).click();
        return new Home(driver);
    }

    public enum Locator implements OnixLocator {
        BACK_HOME_ARROW(By.xpath("//a[@href='#/home']/img")),

        ;

        Locator(By path) {
            this.path = path;
        }

        private By path;

        @Override
        public By getPath() {
            return path;
        }
    }
}