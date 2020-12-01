package main_package.ui.user_mode.page_objects.home_header.workouts;

import main_package.engine.test_engine.FlyTester;
import org.openqa.selenium.By;
import main_package.ui.BasePageObject;
import main_package.engine.OnixLocator;
import main_package.engine.OnixWebDriver;
import main_package.ui.user_mode.general_parts.home.HomePart;

public class Personalised extends BasePageObject implements HomePart {
    public Personalised(OnixWebDriver driver) {
        super(driver);
    }
    @Override
    public Personalised test(FlyTester flyTester) {
        flyTester.test();
        return this;
    }

    public Browse clickBrowseTab() {
        driver.findElement(Locator.BROWSE_TAB).click();
        logger.debug("'Browse' from 'Personalised'");
        return new Browse(driver);
    }
    public MyWorkouts clickMyWorkoutsTab() {
        driver.findElement(Locator.MY_WORKOUTS_TAB).click();
        logger.debug("'MyWorkouts' from 'Personalised'");
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
