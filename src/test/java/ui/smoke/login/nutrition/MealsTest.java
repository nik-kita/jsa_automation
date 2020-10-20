package ui.smoke.login.nutrition;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ui.OnixAssert;
import ui.engine.OnixLocator;
import ui.smoke.login.JsaLoginBaseTestRunner;
import ui.user_mode.general_parts.home.HomeHeaderPart;
import ui.user_mode.general_parts.home.HomePart;
import ui.user_mode.page_objects.home.nutrition.Meals;

public class MealsTest extends JsaLoginBaseTestRunner {
    @BeforeClass
    public void goMeals() {
        homeLoginModePO.clickNutritionTab();
    }
    @Test(dataProvider = "getMealsLocators")
    public void mealsTest(OnixLocator locator) {
        new OnixAssert(driver).checkCountOfElementByLocator(locator, 1);
    }
    @DataProvider
    public Object[] getMealsLocators() {
        return mergeArrays(
                HomeHeaderPart.HomeHeaderLocator.values(),
                HomePart.HomeFlyLocator.values(),
                Meals.Locator.values()
        );
    }
}
