package test_package.unit.user_mode.home.nutrition;

import main_package.ui.user_mode.JsaLoginBaseUiTestRunner;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.engine.test_engine.OnixUiAssert;
import main_package.engine.OnixLocator;
import main_package.ui.user_mode.general_parts.home.HomeHeaderPart;
import main_package.ui.user_mode.general_parts.home.HomePart;
import main_package.ui.user_mode.page_objects.home_header.nutrition.Meals;

public class MealsUiTest extends JsaLoginBaseUiTestRunner {
    @BeforeClass
    public void goMeals() {
        homeLoginModePO.clickNutritionTab();
    }
    @Test(dataProvider = "getMealsLocators")
    public void mealsTest(OnixLocator locator) {
        new OnixUiAssert(driver).checkCountOfElementByLocator(locator, 1);
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
