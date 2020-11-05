package ui.user_mode.page_objects.home_header.home;

import org.openqa.selenium.By;
import ui.BasePageObject;
import ui.engine.OnixLocator;
import ui.engine.OnixWebDriver;
import ui.user_mode.general_parts.home.HomeHeaderPart;

public class Challenges extends BasePageObject implements HomeHeaderPart {
    public Challenges(OnixWebDriver driver) {
        super(driver);
    }

    public enum Locator implements OnixLocator {
        BACK_HOME_ARROW(By.xpath("//a[@href='#/home']/img")),

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
