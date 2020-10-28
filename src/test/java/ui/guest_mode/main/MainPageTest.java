package ui.guest_mode.main;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ui.OnixAssert;
import ui.OnixTestRunner;
import ui.engine.OnixLocator;
import ui.guest_mode.general_parts.Footer;
import ui.guest_mode.general_parts.MainHeader;
import ui.guest_mode.page_objects.main.Main;

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
