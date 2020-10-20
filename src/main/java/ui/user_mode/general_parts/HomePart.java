package ui.user_mode.general_parts;

import ui.engine.OnixLocator;
import org.openqa.selenium.By;
import ui.BasePart;
import ui.engine.OnixWebDriver;
import ui.user_mode.page_objects.Main;
import ui.user_mode.page_objects.UserCabinetDropdown;
import ui.user_mode.page_objects.workouts.Personalised;

public interface HomePart extends BasePart {

    default UserCabinetDropdown openUserDropDown() {
        OnixWebDriver driver = getDriver();
        driver.findElement(HomePart.HeaderLocator.MY_CABINET_DROPDOWN).click();
        return new UserCabinetDropdown(driver);
    }
    default Main goMainPage() {
        OnixWebDriver driver = getDriver();
        driver.findElement(HomePart.HeaderLocator.JSA_LOGO).click();
        return new Main(driver);
    }

    default Personalised clickWorkoutsTab() {
        OnixWebDriver driver = getDriver();
        driver.findElement(HeaderLocator.WORKOUTS).click();
        return new Personalised(driver);
    }

    enum HeaderLocator implements OnixLocator {
        JSA_LOGO(By.xpath("//a[@href='/']")),
        HOME(By.cssSelector("#navbar [href='#/home']")),
        WORKOUTS(By.cssSelector("#navbar [href='#/workouts']")),
        LEARN(By.cssSelector("#navbar #coaching")),
        NUTRITION(By.cssSelector("#navbar #nutrition")),
        MY_CABINET_DROPDOWN(By.id("navbarDropdownMenuLink")),
        SUPPORT_BUTTON(By.xpath("//button[contains(text(), 'Support')]")),

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
