package test_package.unit.user_mode;

import main_package.engine.OnixLocator;
import main_package.engine.test_engine.JsaLoginBaseUiTestRunner;
import main_package.ui.___U_S_E_R___.general_parts.MainHeader;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HeaderPartUiTest extends JsaLoginBaseUiTestRunner {
    @BeforeClass
    public void goMain() {
        homeLoginModePO.goMainPage();
    }
    @Test(dataProvider = "mainHeaderPart")
    public void testMainHeader(OnixLocator locator) {
        onixUiAssert.checkCountOfElementByLocator(locator, 1);
    }
    @DataProvider
    public Object[] mainHeaderPart() {
        return MainHeader.HeaderLocator.values();
    }
}
