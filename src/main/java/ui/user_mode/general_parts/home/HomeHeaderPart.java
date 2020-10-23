package ui.user_mode.general_parts.home;

import org.openqa.selenium.By;
import ui.BasePart;
import ui.engine.OnixLocator;
import ui.engine.OnixWebDriver;
import ui.user_mode.page_objects.home_header.home.Home;
import ui.user_mode.page_objects.main.Main;
import ui.user_mode.page_objects.home_header.UserCabinetDropdown;
import ui.user_mode.page_objects.home_header.learn.Learn;
import ui.user_mode.page_objects.home_header.nutrition.Meals;
import ui.user_mode.page_objects.home_header.workouts.Personalised;

public interface HomeHeaderPart extends BasePart {
    default UserCabinetDropdown openUserDropDown() {
        OnixWebDriver driver = getDriver();
        driver.findElement(HomeHeaderPart.HomeHeaderLocator.MY_CABINET_DROPDOWN).click();
        return new UserCabinetDropdown(driver);
    }
    default Main goMainPage() {
        OnixWebDriver driver = getDriver();
        driver.findElement(HomeHeaderPart.HomeHeaderLocator.JSA_LOGO).click();
        return new Main(driver);
    }
    default Home clickHomeTab() {
        OnixWebDriver driver = getDriver();
        driver.findElement(HomeHeaderPart.HomeHeaderLocator.HOME).click();
        return new Home(driver);
    }

    default Personalised clickWorkoutsTab() {
        OnixWebDriver driver = getDriver();
        driver.findElement(HomeHeaderPart.HomeHeaderLocator.WORKOUTS).click();
        return new Personalised(driver);
    }
    default Meals clickNutritionTab() {
        OnixWebDriver driver = getDriver();
        driver.findElement(HomeHeaderLocator.NUTRITION).click();
        return new Meals(driver);
    }
    default Learn clickLearnTab() {
        OnixWebDriver driver = getDriver();
        driver.findElement(HomeHeaderLocator.LEARN).click();
        return new Learn(driver);
    }

    enum HomeHeaderLocator implements OnixLocator {
        JSA_LOGO(By.xpath("//a[@href='/']")),
        HOME(By.cssSelector("#navbar [href='#/home']")),
        WORKOUTS(By.cssSelector("#navbar [href='#/workouts']")),
        LEARN(By.cssSelector("#navbar #coaching")),
        NUTRITION(By.cssSelector("#navbar #nutrition")),
        MY_CABINET_DROPDOWN(By.id("navbarDropdownMenuLink")),
        SUPPORT_BUTTON(By.xpath("//button[contains(text(), 'Support')]")),

        ;

        private By path;

        HomeHeaderLocator(By path) {
            this.path = path;
        }
        @Override
        public By getPath() {
            return path;
        }



    }
}
