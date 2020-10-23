package ui.user_mode.page_objects.home_header.nutrition;

import org.openqa.selenium.By;
import ui.BasePageObject;
import ui.engine.OnixLocator;
import ui.engine.OnixWebDriver;
import ui.user_mode.general_parts.home.HomePart;

public class ShoppingLists extends BasePageObject implements HomePart {
    public ShoppingLists(OnixWebDriver driver) {
        super(driver);
    }
    public Recipes clickRecipesTab() {
        driver.findElement(Locator.RECIPES_TAB).click();
        return new Recipes(driver);
    }
    public Meals clickMealsTab() {
        driver.findElement(Locator.MEALS_TAB).click();
        return new Meals(driver);
    }

    public enum Locator implements OnixLocator {
        RECIPES_TAB(By.cssSelector(".tab-nav-bar-container [href='#/nutrition/recipes']")),
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
