package ui.user_mode.page_objects.home.learn;

import org.openqa.selenium.By;
import ui.BasePageObject;
import ui.engine.OnixLocator;
import ui.engine.OnixWebDriver;
import ui.user_mode.general_parts.home.HomeHeaderPart;

public class SearchVideos extends BasePageObject implements HomeHeaderPart {
    public SearchVideos(OnixWebDriver driver) {
        super(driver);
    }
    public Learn clickBackArrow() {
        driver.findElement(Locator.BACK_ARROW).click();
        return new Learn(driver);
    }

    public enum Locator implements OnixLocator {
        BACK_ARROW(By.cssSelector(".back_link_arrow a")),



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
