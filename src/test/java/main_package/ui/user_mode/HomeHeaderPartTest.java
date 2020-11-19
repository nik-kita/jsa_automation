package main_package.ui.user_mode;

import main_package.ui.engine.OnixLocator;
import main_package.ui.user_mode.general_parts.home.HomeHeaderPart;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HomeHeaderPartTest extends JsaLoginBaseTestRunner {
    @Test(dataProvider = "homeHeader")
    public void homeHeaderPartTest(OnixLocator locator) {
        onixAssert.checkCountOfElementByLocator(locator, 1);
    }
    @DataProvider
    public Object[] homeHeader() {
        return HomeHeaderPart.HomeHeaderLocator.values();
    }
}