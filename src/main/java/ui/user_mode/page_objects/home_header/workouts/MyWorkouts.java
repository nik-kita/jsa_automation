package ui.user_mode.page_objects.home_header.workouts;

import org.openqa.selenium.By;
import ui.BasePageObject;
import ui.engine.OnixLocator;
import ui.engine.OnixWebDriver;
import ui.user_mode.general_parts.home.HomePart;

public class MyWorkouts extends BasePageObject implements HomePart {
    public MyWorkouts(OnixWebDriver driver) {
        super(driver);
    }
    public Personalised clickPersonalisedTab() {
        driver.findElement(Locator.PERSONALISED_TAB).click();
        logger.debug("'Personalised' from 'MyWorkouts'");
        return new Personalised(driver);
    }
    public Browse clickBrowseTab() {
        driver.findElement(Locator.BROWSE_TAB).click();
        logger.debug("'Browse' from 'MyWorkouts'");
        return new Browse(driver);
    }

    public enum Locator implements OnixLocator {
        PERSONALISED_TAB(By.cssSelector(".tab-nav-bar-container [href='#/workouts/personalised']")),
        BROWSE_TAB(By.cssSelector(".tab-nav-bar-container [href='#/workouts/browse']")),

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
