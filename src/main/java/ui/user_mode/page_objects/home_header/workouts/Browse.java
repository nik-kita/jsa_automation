package ui.user_mode.page_objects.home_header.workouts;

import org.openqa.selenium.By;
import ui.BasePageObject;
import ui.engine.OnixLocator;
import ui.engine.OnixWebDriver;
import ui.user_mode.general_parts.home.HomePart;

public class Browse extends BasePageObject implements HomePart {
    public Browse(OnixWebDriver driver) {
        super(driver);
    }

    public Personalised clickPersonalisedTab() {
        driver.findElement(Locator.PERSONALISED_TAB).click();
        logger.debug("'Personalised' from 'Browse'");
        return new Personalised(driver);
    }
    public MyWorkouts clickMyWorkoutsTab() {
        driver.findElement(Locator.MY_WORKOUTS_TAB).click();
        logger.debug("'MyWorkouts' from 'Browse'");
        return new MyWorkouts(driver);
    }


    public enum Locator implements OnixLocator {
        PERSONALISED_TAB(By.cssSelector(".tab-nav-bar-container [href='#/workouts/personalised']")),
        MY_WORKOUTS_TAB(By.cssSelector(".tab-nav-bar-container [href='#/workouts/myworkouts']"))
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
