package test_package.unit.user_mode;

import main_package.engine.OnixLocator;
import main_package.engine.test_engine.JsaLoginBaseUiTestRunner;
import main_package.ui.user_mode.general_parts.home.HomeHeaderPart;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HomeHeaderPartUiTest extends JsaLoginBaseUiTestRunner {
    @Test(dataProvider = "homeHeader")
    public void homeHeaderPartTest(OnixLocator locator) {
        onixUiAssert.checkCountOfElementByLocator(locator, 1);
    }
    @DataProvider
    public Object[] homeHeader() {
        return HomeHeaderPart.HomeHeaderLocator.values();
    }
}
