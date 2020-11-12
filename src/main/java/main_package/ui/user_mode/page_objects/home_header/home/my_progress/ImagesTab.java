package main_package.ui.user_mode.page_objects.home_header.home.my_progress;

import org.openqa.selenium.By;
import main_package.ui.BasePageObject;
import main_package.ui.engine.OnixLocator;
import main_package.ui.engine.OnixWebDriver;
import main_package.ui.user_mode.general_parts.home.HomeHeaderPart;

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
