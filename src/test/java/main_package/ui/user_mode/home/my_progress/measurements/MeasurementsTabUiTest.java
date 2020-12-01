package main_package.ui.user_mode.home.my_progress.measurements;

import main_package.ui.user_mode.JsaLoginBaseUiTestRunner;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.engine.OnixLocator;
import main_package.ui.user_mode.page_objects.home_header.home.my_progress.measurements_tab.MeasurementsTab;

public class MeasurementsTabUiTest extends JsaLoginBaseUiTestRunner {
    @BeforeClass
    public void openMeasurementsTab() {
        homeLoginModePO.clickMyProgressLink().clickMeasurementsTab();
    }
    @Test(dataProvider = "getMeasurementsTabLocators")
    public void measurementsTabTest(OnixLocator locator) {
        onixUiAssert.checkCountOfElementByLocator(locator,1);
    }
    @DataProvider
    public Object[] getMeasurementsTabLocators() {
        return mergeArrays(
                MeasurementsTab.Locator.values(),
                MeasurementsTab.HomeHeaderLocator.values()
        );
    }
}
