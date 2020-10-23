package ui.user_mode.page_objects.home_header.workouts;

import org.openqa.selenium.By;
import ui.BasePageObject;
import ui.engine.OnixLocator;
import ui.engine.OnixWebDriver;
import ui.user_mode.general_parts.home.HomePart;

public class Personalised extends BasePageObject implements HomePart {
    public Personalised(OnixWebDriver driver) {
        super(driver);
    }

    public Browse clickBrowseTab() {
        driver.findElement(Locator.BROWSE_TAB).click();
        return new Browse(driver);
    }
    public MyWorkouts clickMyWorkoutsTab() {
        driver.findElement(Locator.MY_WORKOUTS_TAB).click();
        return new MyWorkouts(driver);
    }


    public enum Locator implements OnixLocator {
        BROWSE_TAB(By.cssSelector(".tab-nav-bar-container [href='#/workouts/browse']")),
        MY_WORKOUTS_TAB(By.cssSelector(".tab-nav-bar-container [href='#/workouts/myworkouts']")),

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
