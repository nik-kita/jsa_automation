package ui.user_mode.general_parts.home;

import ui.engine.OnixLocator;
import org.openqa.selenium.By;
import ui.BasePart;
import ui.engine.OnixWebDriver;
import ui.user_mode.page_objects.Home;
import ui.user_mode.page_objects.Main;
import ui.user_mode.page_objects.UserCabinetDropdown;
import ui.user_mode.page_objects.home.workouts.Personalised;

public interface HomePart extends HomeHeaderPart {

    enum HomeFlyLocator implements OnixLocator {
        SUPPORT_BUTTON(By.xpath("//button[contains(text(), 'Support')]")),

        ;

        private By path;

        HomeFlyLocator(By path) {
            this.path = path;
        }
        @Override
        public By getPath() {
            return path;
        }



    }
}
