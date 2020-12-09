package main_package.ui.___U_S_E_R___.page_objects.home_header.learn;

import main_package.engine.test_engine.FlyTester;
import org.openqa.selenium.By;
import main_package.ui.BasePageObject;
import main_package.engine.OnixLocator;
import main_package.engine.OnixWebDriver;
import main_package.ui.___U_S_E_R___.general_parts.home.HomeHeader;

public class SearchVideos extends BasePageObject implements HomeHeader {

    public SearchVideos(OnixWebDriver driver) {
        super(driver);
    }
    @Override
    public SearchVideos test(FlyTester flyTester) {
        flyTester.test();
        return this;
    }

    public Learn clickBackArrow() {
        driver.findElement(Locator.BACK_ARROW).click();
        logger.debug("'Learn' from 'SearchVideos'");
        return new Learn(driver);
    }

    public enum Locator implements OnixLocator {
        BACK_ARROW(By.cssSelector("a.back_link_arrow img")),



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
