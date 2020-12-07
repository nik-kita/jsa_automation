package test_package.unit.user_mode.home.learn;

import main_package.engine.OnixLocator;

import main_package.ui.___U_S_E_R___.general_parts.home.HomeHeaderPart;
import main_package.ui.___U_S_E_R___.page_objects.home_header.learn.CategoriesMultiPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.engine.test_engine.JsaLoginBaseUiTestRunner;

public class CategoriesMultiPageUiTest extends JsaLoginBaseUiTestRunner {
    CategoriesMultiPage categoriesMultiPage;
    @BeforeClass
    public void goCategories() {
        categoriesMultiPage = homeLoginModePO.clickLearnTab().clickCategory();
    }
    @Test(dataProvider = "originalLocators")
    public void testOriginal(OnixLocator locator) {
        onixUiAssert.checkCountOfElementByLocator(locator, 1);
    }
    @DataProvider
    public Object[] originalLocators() {
        return mergeArrays(
                HomeHeaderPart.HomeHeaderLocator.values(),
                CategoriesMultiPage.Locator.values()
        );
    }
    @Test(dataProvider = "locators")
    public void checkDuplicateLocators(OnixLocator locator) {
        onixUiAssert.checkMinimumOfElementsByLocator(locator, 1);
    }
    @DataProvider
    public Object[] locators() {
        return CategoriesMultiPage.Locators.values();
    }
}
