package main_package.ui.___U_S_E_R___.page_objects.home_header.nutrition;

import main_package.engine.test_engine.FlyTester;
import org.openqa.selenium.By;
import main_package.ui.BasePageObject;
import main_package.engine.OnixLocator;
import main_package.engine.OnixWebDriver;
import main_package.ui.___U_S_E_R___.general_parts.home.HomePart;

public class ShoppingLists extends BasePageObject implements HomePart {
    public ShoppingLists(OnixWebDriver driver) {
        super(driver);
    }
    @Override
    public ShoppingLists test(FlyTester flyTester) {
        flyTester.test();
        return this;
    }
    public Recipes clickRecipesTab() {
        driver.findElement(Locator.RECIPES_TAB).click();
        logger.debug("'Recipes' from 'ShoppingLists'");
        return new Recipes(driver);
    }
    public Meals clickMealsTab() {
        driver.findElement(Locator.MEALS_TAB).click();
        logger.debug("'Meals' from 'ShoppingLists'");
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
