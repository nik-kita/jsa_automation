package main_package.ui.user_mode.home.nutrition;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.ui.engine.OnixAssert;
import main_package.ui.engine.OnixLocator;
import main_package.ui.user_mode.JsaLoginBaseTestRunner;
import main_package.ui.user_mode.general_parts.home.HomeHeaderPart;
import main_package.ui.user_mode.general_parts.home.HomePart;
import main_package.ui.user_mode.page_objects.home_header.nutrition.ShoppingLists;

public class ShoppingListsTest extends JsaLoginBaseTestRunner {
    @BeforeClass
    public void goShoppingListsPage() {
        homeLoginModePO.clickNutritionTab().clickShoppingListsTab();
    }
    @Test(dataProvider = "getShoppingListsLocators")
    public void shoppingListsTest(OnixLocator locator) {
        new OnixAssert(driver).checkCountOfElementByLocator(locator, 1);
    }
    @DataProvider
    public Object[] getShoppingListsLocators() {
        return mergeArrays(
                HomeHeaderPart.HomeHeaderLocator.values(),
                HomePart.HomeFlyLocator.values(),
                ShoppingLists.Locator.values()
        );
    }
}
