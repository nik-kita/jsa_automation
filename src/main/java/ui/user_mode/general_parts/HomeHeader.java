package ui.user_mode.general_parts;

import ui.engine.OnixLocator;
import org.openqa.selenium.By;
import ui.BasePart;
import ui.engine.OnixWebDriver;
import ui.user_mode.page_objects.Main;
import ui.user_mode.page_objects.home.UserCabinetDropdown;

public interface HomeHeader extends BasePart {

    default UserCabinetDropdown openUserDropDown() {
        OnixWebDriver driver = getDriver();
        driver.findElement(HomeHeader.HeaderLocator.MY_CABINET_DROPDOWN).click();
        return new UserCabinetDropdown(driver);
    }
    default Main goMainPage() {
        OnixWebDriver driver = getDriver();
        driver.findElement(HomeHeader.HeaderLocator.JSA_LOGO).click();
        return new Main(driver);
    }

    enum HeaderLocator implements OnixLocator {
        JSA_LOGO(By.xpath("//a[@href='/']")),
        HOME(By.cssSelector("#navbar [href='#/home']")),
        WORKOUTS(By.cssSelector("#navbar [href='#/workouts']")),
        LEARN(By.cssSelector("#navbar #coaching")),
        NUTRITION(By.cssSelector("#navbar #nutrition")),
        MY_CABINET_DROPDOWN(By.id("navbarDropdownMenuLink")),


        ;

        private By path;

        HeaderLocator(By path) {
            this.path = path;
        }
        @Override
        public By getPath() {
            return path;
        }



    }
}
