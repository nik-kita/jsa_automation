package main_package.ui.user_mode.home.learn;

import main_package.ui.engine.OnixLocator;
import main_package.ui.user_mode.JsaLoginBaseTestRunner;
import main_package.ui.user_mode.general_parts.home.HomeHeaderPart;
import main_package.ui.user_mode.page_objects.home_header.learn.CategoriesMultiPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CategoriesMultiPageTest extends JsaLoginBaseTestRunner {
    CategoriesMultiPage categoriesMultiPage;
    @BeforeClass
    public void goCategories() {
        categoriesMultiPage = homeLoginModePO.clickLearnTab().clickCategory();
    }
    @Test(dataProvider = "originalLocators")
    public void testOriginal(OnixLocator locator) {
        onixAssert.checkCountOfElementByLocator(locator, 1);
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
        onixAssert.checkMinimumOfElementsByLocator(locator, 1);
    }
    @DataProvider
    public Object[] locators() {
        return CategoriesMultiPage.Locators.values();
    }
}
