package main_package.ui.user_mode.home.my_progress.measurements;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.ui.engine.OnixLocator;
import main_package.ui.user_mode.JsaLoginBaseTestRunner;
import main_package.ui.user_mode.page_objects.home_header.home.my_progress.measurements_tab.MeasurementsTab;

public class MeasurementsTabTest extends JsaLoginBaseTestRunner {
    @BeforeClass
    public void openMeasurementsTab() {
        homeLoginModePO.clickMyProgressLink().clickMeasurementsTab();
    }
    @Test(dataProvider = "getMeasurementsTabLocators")
    public void measurementsTabTest(OnixLocator locator) {
        onixAssert.checkCountOfElementByLocator(locator,1);
    }
    @DataProvider
    public Object[] getMeasurementsTabLocators() {
        return mergeArrays(
                MeasurementsTab.Locator.values(),
                MeasurementsTab.HomeHeaderLocator.values()
        );
    }
}
