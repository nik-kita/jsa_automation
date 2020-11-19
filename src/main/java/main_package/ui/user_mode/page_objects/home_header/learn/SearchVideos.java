package main_package.ui.user_mode.page_objects.home_header.learn;

import org.openqa.selenium.By;
import main_package.ui.BasePageObject;
import main_package.ui.engine.OnixLocator;
import main_package.ui.engine.OnixWebDriver;
import main_package.ui.user_mode.general_parts.home.HomeHeaderPart;

public class SearchVideos extends BasePageObject implements HomeHeaderPart {

    public SearchVideos(OnixWebDriver driver) {
        super(driver);
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