package test_package.unit.user_mode.home.my_progress.measurements;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.engine.OnixLocator;
import main_package.ui.___U_S_E_R___.page_objects.home_header.home.my_progress.measurements_tab.MeasurementsTab;
import main_package.engine.test_engine.JsaLoginBaseUiTestRunner;

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
