package main_package.ui.user_mode.page_objects.home_header.nutrition;

import org.openqa.selenium.By;
import main_package.ui.BasePageObject;
import main_package.ui.engine.OnixLocator;
import main_package.ui.engine.OnixWebDriver;
import main_package.ui.user_mode.general_parts.home.HomePart;

public class Meals extends BasePageObject implements HomePart {

    public Meals(OnixWebDriver driver) {
        super(driver);
    }

    public Recipes clickRecipesTab() {
        driver.findElement(Locator.RECIPES_TAB).click();
        logger.debug("'Recipes' from 'Meals'");
        return new Recipes(driver);
    }
    public ShoppingLists clickShoppingListsTab() {
        driver.findElement(Locator.SHOPPING_LISTS_TAB).click();
        logger.debug("'ShoppingLists' from 'Meals'");
        return new ShoppingLists(driver);
    }
    public enum Locator implements OnixLocator {
        RECIPES_TAB(By.cssSelector(".tab-nav-bar-container [href='#/nutrition/recipes']")),
        SHOPPING_LISTS_TAB(By.cssSelector(".tab-nav-bar-container [href='#/nutrition/shopping-lists']")),



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
