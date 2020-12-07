package main_package.ui.___U_S_E_R___.page_objects.home_header.workouts;

import main_package.engine.test_engine.FlyTester;
import org.openqa.selenium.By;
import main_package.ui.BasePageObject;
import main_package.engine.OnixLocator;
import main_package.engine.OnixWebDriver;
import main_package.ui.___U_S_E_R___.general_parts.home.HomePart;

public class MyWorkouts extends BasePageObject implements HomePart {
    public MyWorkouts(OnixWebDriver driver) {
        super(driver);
    }
    @Override
    public MyWorkouts test(FlyTester flyTester) {
        flyTester.test();
        return this;
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
