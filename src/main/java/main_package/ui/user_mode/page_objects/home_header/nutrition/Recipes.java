package main_package.ui.user_mode.page_objects.home_header.nutrition;

import main_package.ui.engine.FlyTester;
import org.openqa.selenium.By;
import main_package.ui.BasePageObject;
import main_package.ui.engine.OnixLocator;
import main_package.ui.engine.OnixWebDriver;
import main_package.ui.user_mode.general_parts.home.HomePart;

public class Recipes extends BasePageObject implements HomePart {
    public Recipes(OnixWebDriver driver) {
        super(driver);
    }
    @Override
    public Recipes test(FlyTester flyTester) {
        flyTester.test();
        return this;
    }
    public Meals clickMealsTab() {
        driver.findElement(Locator.MEALS_TAB).click();
        logger.debug("'Meals' from 'Recipes'");
        return new Meals(driver);
    }
    public ShoppingLists clickShoppingListsTab() {
        driver.findElement(Locator.SHOPPING_LISTS_TAB).click();
        logger.debug("'ShoppingLists' from 'Recipes'");
        return new ShoppingLists(driver);
    }

    public enum Locator implements OnixLocator {
        SHOPPING_LISTS_TAB(By.cssSelector(".tab-nav-bar-container [href='#/nutrition/shopping-lists']")),
        MEALS_TAB(By.cssSelector(".tab-nav-bar-container [href='#/nutrition/meals']")),



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
