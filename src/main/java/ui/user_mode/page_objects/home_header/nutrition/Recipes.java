package ui.user_mode.page_objects.home_header.nutrition;

import org.openqa.selenium.By;
import ui.BasePageObject;
import ui.engine.OnixLocator;
import ui.engine.OnixWebDriver;
import ui.user_mode.general_parts.home.HomePart;

public class Recipes extends BasePageObject implements HomePart {
    public Recipes(OnixWebDriver driver) {
        super(driver);
    }
    public Meals clickMealsTab() {
        driver.findElement(Locator.MEALS_TAB).click();
        return new Meals(driver);
    }
    public ShoppingLists clickShoppingListsTab() {
        driver.findElement(Locator.SHOPPING_LISTS_TAB).click();
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
