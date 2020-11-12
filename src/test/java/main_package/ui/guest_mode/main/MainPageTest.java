package main_package.ui.guest_mode.main;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test_package.test_engine.OnixTestRunner;
import main_package.ui.engine.OnixLocator;
import main_package.ui.guest_mode.page_objects.main.Main;

public class MainPageTest extends OnixTestRunner {

    @BeforeClass
    public void goHomePage() {
        openSite();
    }


    @Test(dataProvider = "getMainPageLocators")
    public void mainPageTest(OnixLocator locator) {
        onixAssert.
                checkCountOfElementByLocator(locator, 1);
    }

    @DataProvider
    public Object[] getMainPageLocators() {
        return mergeArrays(
                Main.Locator.values(),
                Main.HeaderLocator.values(),
                Main.FooterLocator.values()
        );
    }
}
