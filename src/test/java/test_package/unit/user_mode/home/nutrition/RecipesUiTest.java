package test_package.unit.user_mode.home.nutrition;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.engine.OnixLocator;
import main_package.ui.___U_S_E_R___.general_parts.home.HomeHeader;
import main_package.ui.___U_S_E_R___.general_parts.home.HomePart;
import main_package.ui.___U_S_E_R___.page_objects.home_header.nutrition.Recipes;
import main_package.engine.test_engine.JsaLoginBaseUiTestRunner;

public class RecipesUiTest extends JsaLoginBaseUiTestRunner {
    @BeforeClass
    public void goRecipes() {
        homeLoginModePO.clickNutritionTab().clickRecipesTab();
    }
    @Test(dataProvider = "getRecipesLocators")
    public void recipesTest(OnixLocator locator) {
        onixUiAssert.checkCountOfElementByLocator(locator, 1);
    }
    @DataProvider
    public Object[] getRecipesLocators() {
        return mergeArrays(
                HomePart.HomeFlyLocator.values(),
                HomeHeader.HomeHeaderLocator.values(),
                Recipes.Locator.values()
        );
    }
}
