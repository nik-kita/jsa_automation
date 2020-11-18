package main_package.ui.user_mode;

import main_package.ui.engine.OnixLocator;
import main_package.ui.user_mode.general_parts.MainHeader;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HeaderPartTest extends JsaLoginBaseTestRunner {
    @BeforeClass
    public void goMain() {
        homeLoginModePO.goMainPage();
    }
    @Test(dataProvider = "mainHeaderPart")
    public void testMainHeader(OnixLocator locator) {
        onixAssert.checkCountOfElementByLocator(locator, 1);
    }
    @DataProvider
    public Object[] mainHeaderPart() {
        return MainHeader.HeaderLocator.values();
    }
}
