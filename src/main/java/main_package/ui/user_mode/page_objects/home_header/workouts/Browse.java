package main_package.ui.user_mode.page_objects.home_header.workouts;

import main_package.ui.engine.FlyTester;
import org.openqa.selenium.By;
import main_package.ui.BasePageObject;
import main_package.ui.engine.OnixLocator;
import main_package.ui.engine.OnixWebDriver;
import main_package.ui.user_mode.general_parts.home.HomePart;

public class Browse extends BasePageObject implements HomePart {
    public Browse(OnixWebDriver driver) {
        super(driver);
    }
    @Override
    public Browse test(FlyTester flyTester) {
        flyTester.test();
        return this;
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
