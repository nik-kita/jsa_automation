package ui.user_mode.page_objects.home_header.home;

import org.openqa.selenium.By;
import ui.BasePageObject;
import ui.engine.OnixLocator;
import ui.engine.OnixWebDriver;
import ui.user_mode.general_parts.home.HomeHeaderPart;

public class PersonalTrainer extends BasePageObject implements HomeHeaderPart {

    public PersonalTrainer(OnixWebDriver driver) {
        super(driver);
    }

    public enum Locator implements OnixLocator {
        CLOSE_ICON(By.xpath("//div[contains(@class, 'header_two')]//img[contains(@src, 'ic_close')]")),
        INFO_ICON(By.xpath("//img[contains(@src, 'ic_info')]")),

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
