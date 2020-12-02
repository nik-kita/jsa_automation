package test_package.unit.user_mode.home.learn;

import main_package.engine.OnixLocator;
import main_package.ui.user_mode.JsaLoginBaseUiTestRunner;
import main_package.ui.user_mode.page_objects.home_header.learn.Favourites;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FavouritesUiTest extends JsaLoginBaseUiTestRunner {
    @BeforeClass
    public void goFavourites(){
        homeLoginModePO.clickLearnTab().clickFavourites();
    }
    @Test(dataProvider = "originalLocators")
    public void testFavouritesPage(OnixLocator locator) {
        onixUiAssert.checkCountOfElementByLocator(locator, 1);
    }
    @DataProvider
    public Object[] originalLocators() {
        return Favourites.Locator.values();
    }
}
