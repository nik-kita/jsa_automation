package main_package.ui.user_mode.page_objects.home_header.home.my_progress;

import main_package.engine.test_engine.FlyTester;
import org.openqa.selenium.By;
import main_package.ui.BasePageObject;
import main_package.engine.OnixLocator;
import main_package.engine.OnixWebDriver;
import main_package.ui.user_mode.general_parts.home.HomeHeaderPart;

public class ImagesTab extends BasePageObject implements HomeHeaderPart {
    public ImagesTab(OnixWebDriver driver) {
        super(driver);
    }
    @Override
    public ImagesTab test(FlyTester flyTester) {
        flyTester.test();
        return this;
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
