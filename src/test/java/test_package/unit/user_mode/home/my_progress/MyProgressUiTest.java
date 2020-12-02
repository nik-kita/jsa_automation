package test_package.unit.user_mode.home.my_progress;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.engine.OnixLocator;
import main_package.ui.user_mode.JsaLoginBaseUiTestRunner;
import main_package.ui.user_mode.page_objects.home_header.home.my_progress.MyProgress;

public class MyProgressUiTest extends JsaLoginBaseUiTestRunner {
    MyProgress myProgress;
    @BeforeClass
    public void goMyProgressPage() {
        myProgress = homeLoginModePO.clickMyProgressLink();
    }
    @Test(dataProvider = "getMyProgressLocators")
    public void myProgressTest(OnixLocator locator) {
        onixUiAssert.checkCountOfElementByLocator(locator, 1);
    }
    @DataProvider
    public Object[] getMyProgressLocators() {
        return mergeArrays(
                MyProgress.Locator.values(),
                MyProgress.HomeHeaderLocator.values()
        );
    }
}
