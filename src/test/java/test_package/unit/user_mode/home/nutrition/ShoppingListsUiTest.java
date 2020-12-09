package test_package.unit.user_mode.home.nutrition;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.engine.test_engine.OnixUiAssert;
import main_package.engine.OnixLocator;
import main_package.ui.___U_S_E_R___.general_parts.home.HomeHeader;
import main_package.ui.___U_S_E_R___.general_parts.home.HomePart;
import main_package.ui.___U_S_E_R___.page_objects.home_header.nutrition.ShoppingLists;
import main_package.engine.test_engine.JsaLoginBaseUiTestRunner;

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
                HomeHeader.HomeHeaderLocator.values(),
                HomePart.HomeFlyLocator.values(),
                ShoppingLists.Locator.values()
        );
    }
}
