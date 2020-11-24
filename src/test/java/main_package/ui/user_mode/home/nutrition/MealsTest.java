package main_package.ui.user_mode.home.nutrition;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.ui.engine.OnixAssert;
import main_package.ui.engine.OnixLocator;
import main_package.ui.user_mode.JsaLoginBaseTestRunner;
import main_package.ui.user_mode.general_parts.home.HomeHeaderPart;
import main_package.ui.user_mode.general_parts.home.HomePart;
import main_package.ui.user_mode.page_objects.home_header.nutrition.Meals;

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
