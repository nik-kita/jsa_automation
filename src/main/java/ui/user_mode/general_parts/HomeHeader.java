package ui.user_mode.general_parts;

import ui.engine.OnixLocator;
import org.openqa.selenium.By;
import ui.BasePart;

public interface HomeHeader extends BasePart {

    enum Locator implements OnixLocator {
        JSA_LOGO(By.xpath("//a[@href='/']")),
        HOME(By.cssSelector("#navbar [href='#/home']")),
        WORKOUTS(By.cssSelector("#navbar [href='#/workouts']")),
        LEARN(By.cssSelector("#navbar #coaching")),
        NUTRITION(By.cssSelector("#navbar #nutrition")),
        MY_CABINET_DROPDOWN(By.id("navbarDropdownMenuLink")),


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
