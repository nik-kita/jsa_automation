package ui.smoke.login.nutrition;

import org.checkerframework.checker.units.qual.A;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ui.OnixAssert;
import ui.engine.OnixLocator;
import ui.smoke.login.JsaLoginBaseTestRunner;
import ui.user_mode.general_parts.home.HomeHeaderPart;
import ui.user_mode.general_parts.home.HomePart;
import ui.user_mode.page_objects.home.nutrition.ShoppingLists;

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
