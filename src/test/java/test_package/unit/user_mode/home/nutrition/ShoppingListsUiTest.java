package test_package.unit.user_mode.home.nutrition;

import main_package.ui.user_mode.JsaLoginBaseUiTestRunner;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.engine.test_engine.OnixUiAssert;
import main_package.engine.OnixLocator;
import main_package.ui.user_mode.general_parts.home.HomeHeaderPart;
import main_package.ui.user_mode.general_parts.home.HomePart;
import main_package.ui.user_mode.page_objects.home_header.nutrition.ShoppingLists;

public class ShoppingListsUiTest extends JsaLoginBaseUiTestRunner {
    @BeforeClass
    public void goShoppingListsPage() {
        homeLoginModePO.clickNutritionTab().clickShoppingListsTab();
    }
    @Test(dataProvider = "getShoppingListsLocators")
    public void shoppingListsTest(OnixLocator locator) {
        new OnixUiAssert(driver).checkCountOfElementByLocator(locator, 1);
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
