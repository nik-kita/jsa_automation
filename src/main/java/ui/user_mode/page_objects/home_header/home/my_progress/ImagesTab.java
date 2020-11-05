package ui.user_mode.page_objects.home_header.home.my_progress;

import org.openqa.selenium.By;
import ui.BasePageObject;
import ui.engine.OnixLocator;
import ui.engine.OnixWebDriver;
import ui.user_mode.general_parts.home.HomeHeaderPart;

public class ImagesTab extends BasePageObject implements HomeHeaderPart {
    public ImagesTab(OnixWebDriver driver) {
        super(driver);
    }

    public enum Locator implements OnixLocator {
        ADD_IMAGE_BUTTON(By.cssSelector(".add_image_button img"))

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
