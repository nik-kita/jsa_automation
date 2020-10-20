package ui.user_mode.page_objects.home.learn;

import org.openqa.selenium.By;
import ui.BasePageObject;
import ui.engine.OnixLocator;
import ui.engine.OnixWebDriver;
import ui.user_mode.general_parts.home.HomePart;

public class Learn extends BasePageObject implements HomePart {
    public Learn(OnixWebDriver driver) {
        super(driver);
    }
    public SearchVideos clickSearchIcon() {
        driver.findElement(Locator.SEARCH_ICON).click();
        return new SearchVideos(driver);
    }



    public enum Locator implements OnixLocator {
        SEARCH_ICON(By.cssSelector(".navbar-nav [href='#/learn/search']")),


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
