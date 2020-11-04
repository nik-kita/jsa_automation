package ui.user_mode.page_objects.home_header.home;

import org.openqa.selenium.By;
import ui.BasePageObject;
import ui.engine.OnixLocator;
import ui.engine.OnixWebDriver;
import ui.user_mode.general_parts.home.HomeHeaderPart;

public class Steps extends BasePageObject implements HomeHeaderPart {
    public Steps(OnixWebDriver driver) {
        super(driver);
    }



    public enum Locator implements OnixLocator {
        BACK_HOME_ARROW(By.xpath("//a[@href='#/home']/img")),
        EDIT_YOUR_GOAL_BUTTON(By.cssSelector(".steps_goal img")),
        EDIT_TODAY_STEPS_BUTTON(By.cssSelector(".todays_steps img")),
        ONE_WEEK_BUTTON(By.xpath("//div[text() = '1 W']")),
        ONE_MONTH_BUTTON(By.xpath("//div[text() = '1 M']")),
        THREE_MONTH_BUTTON(By.xpath("//div[text()= '3 M']")),

        ;
        Locator(By path) {
            this.path = path;
        }

        private By path;

        @Override
        public By getPath() {
            return path;
        }
    }
}
