package ui.user_mode.home.my_progress.measurements;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ui.engine.OnixLocator;
import ui.user_mode.JsaLoginBaseTestRunner;
import ui.user_mode.general_parts.home.HomeHeaderPart;
import ui.user_mode.page_objects.home_header.home.my_progress.measurements_tab.MeasurementsTab;

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
