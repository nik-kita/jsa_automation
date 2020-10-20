package ui.smoke.login.nutrition;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ui.OnixAssert;
import ui.engine.OnixLocator;
import ui.smoke.login.JsaLoginBaseTestRunner;
import ui.user_mode.general_parts.home.HomeHeaderPart;
import ui.user_mode.general_parts.home.HomePart;
import ui.user_mode.page_objects.home.nutrition.Recipes;

public class RecipesTest extends JsaLoginBaseTestRunner {
    @BeforeClass
    public void goRecipes() {
        homeLoginModePO.clickNutritionTab().clickRecipesTab();
    }
    @Test(dataProvider = "getRecipesLocators")
    public void recipesTest(OnixLocator locator) {
        new OnixAssert(driver).checkCountOfElementByLocator(locator, 1);
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
