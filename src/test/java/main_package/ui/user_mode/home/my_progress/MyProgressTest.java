package main_package.ui.user_mode.home.my_progress;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.ui.engine.OnixLocator;
import main_package.ui.user_mode.JsaLoginBaseTestRunner;
import main_package.ui.user_mode.page_objects.home_header.home.my_progress.MyProgress;

public class MyProgressTest extends JsaLoginBaseTestRunner {
    MyProgress myProgress;
    @BeforeClass
    public void goMyProgressPage() {
        myProgress = homeLoginModePO.clickMyProgressLink();
    }
    @Test(dataProvider = "getMyProgressLocators")
    public void myProgressTest(OnixLocator locator) {
        onixAssert.checkCountOfElementByLocator(locator, 1);
    }
    @DataProvider
    public Object[] getMyProgressLocators() {
        return mergeArrays(
                MyProgress.Locator.values(),
                MyProgress.HomeHeaderLocator.values()
        );
    }
}
