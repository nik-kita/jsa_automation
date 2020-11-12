package main_package.ui.user_mode.home.nutrition;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.ui.engine.OnixLocator;
import main_package.ui.user_mode.JsaLoginBaseTestRunner;
import main_package.ui.user_mode.general_parts.home.HomeHeaderPart;
import main_package.ui.user_mode.general_parts.home.HomePart;
import main_package.ui.user_mode.page_objects.home_header.nutrition.Recipes;

public class RecipesTest extends JsaLoginBaseTestRunner {
    @BeforeClass
    public void goRecipes() {
        homeLoginModePO.clickNutritionTab().clickRecipesTab();
    }
    @Test(dataProvider = "getRecipesLocators")
    public void recipesTest(OnixLocator locator) {
        onixAssert.checkCountOfElementByLocator(locator, 1);
    }
    @DataProvider
    public Object[] getRecipesLocators() {
        return mergeArrays(
                HomePart.HomeFlyLocator.values(),
                HomeHeaderPart.HomeHeaderLocator.values(),
                Recipes.Locator.values()
        );
    }
}
