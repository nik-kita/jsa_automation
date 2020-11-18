package main_package.ui.user_mode.general_parts.home;

import org.openqa.selenium.By;
import main_package.ui.BasePart;
import main_package.ui.engine.OnixLocator;
import main_package.ui.engine.OnixWebDriver;
import main_package.ui.user_mode.page_objects.home_header.home.Home;
import main_package.ui.user_mode.page_objects.main.Main;
import main_package.ui.user_mode.page_objects.home_header.UserCabinetDropdown;
import main_package.ui.user_mode.page_objects.home_header.learn.Learn;
import main_package.ui.user_mode.page_objects.home_header.nutrition.Meals;
import main_package.ui.user_mode.page_objects.home_header.workouts.Personalised;

public interface HomeHeaderPart extends BasePart {
    default UserCabinetDropdown openUserDropDown() {
        OnixWebDriver driver = getDriver();
        driver.findElement(HomeHeaderLocator.MY_CABINET_DROPDOWN).click();
        getLogger().debug("open 'UserCabinetDropdown' from home header");
        return new UserCabinetDropdown(driver);
    }
    default Main goMainPage() {
        OnixWebDriver driver = getDriver();
        driver.findElement(HomeHeaderPart.HomeHeaderLocator.JSA_LOGO).click();
        getLogger().debug("'Main' from home header");
        return new Main(driver);
    }
    default Home clickHomeTab() {
        OnixWebDriver driver = getDriver();
        driver.findElement(HomeHeaderPart.HomeHeaderLocator.HOME).click();
        getLogger().debug("'Home' from home header");
        return new Home(driver);
    }

    default Personalised clickWorkoutsTab() {
        OnixWebDriver driver = getDriver();
        driver.findElement(HomeHeaderPart.HomeHeaderLocator.WORKOUTS).click();
        getLogger().debug("'Personalised' from home header");
        return new Personalised(driver);
    }
    default Meals clickNutritionTab() {
        OnixWebDriver driver = getDriver();
        driver.findElement(HomeHeaderLocator.NUTRITION).click();
        getLogger().debug("'Meals' from home header");
        return new Meals(driver);
    }
    default Learn clickLearnTab() {
        OnixWebDriver driver = getDriver();
        driver.findElement(HomeHeaderLocator.LEARN).click();
        getLogger().debug("'Learn' from home header");
        return new Learn(driver);
    }

    enum HomeHeaderLocator implements OnixLocator {
        JSA_LOGO(By.xpath("//a[@href='/']")),
        HOME(By.cssSelector("#navbar [href='#/home']")),
        WORKOUTS(By.cssSelector("#navbar [href='#/workouts']")),
        LEARN(By.cssSelector("#navbar #coaching")),
        NUTRITION(By.cssSelector("#navbar #nutrition")),
        MY_CABINET_DROPDOWN(By.id("navbarDropdownMenuLink")),


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
