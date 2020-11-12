package main_package.ui.user_mode.general_parts.home;

import main_package.ui.engine.OnixLocator;
import org.openqa.selenium.By;

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
