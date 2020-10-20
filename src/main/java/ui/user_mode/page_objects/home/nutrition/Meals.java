package ui.user_mode.page_objects.home.nutrition;

import org.openqa.selenium.By;
import ui.BasePageObject;
import ui.engine.OnixLocator;
import ui.engine.OnixWebDriver;
import ui.user_mode.general_parts.home.HomePart;
import ui.user_mode.page_objects.home.learn.Learn;

public class Meals extends BasePageObject implements HomePart {
    public Meals(OnixWebDriver driver) {
        super(driver);
    }
    public Recipes clickRecipesTab() {
        driver.findElement(Locator.RECIPES_TAB).click();
        return new Recipes(driver);
    }
    public ShoppingLists clickShoppingListsTab() {
        driver.findElement(Locator.SHOPPING_LISTS_TAB).click();
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
