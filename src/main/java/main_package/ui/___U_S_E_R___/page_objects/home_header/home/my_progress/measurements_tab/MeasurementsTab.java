package main_package.ui.___U_S_E_R___.page_objects.home_header.home.my_progress.measurements_tab;

import main_package.engine.test_engine.FlyTester;
import org.openqa.selenium.By;
import main_package.ui.BasePageObject;
import main_package.engine.OnixLocator;
import main_package.engine.OnixWebDriver;
import main_package.ui.___U_S_E_R___.general_parts.home.HomeHeader;

public class MeasurementsTab extends BasePageObject implements HomeHeader {
    public MeasurementsTab(OnixWebDriver driver) {
        super(driver);
    }
    @Override
    public MeasurementsTab test(FlyTester flyTester) {
        flyTester.test();
        return this;
    }

    public enum Locator implements OnixLocator {
        BENCH(By.xpath("//p[text()='Bench']")),
        DEADLIFT(By.xpath("//p[text()='Deadlift']")),
        SQUAT(By.xpath("//p[text()='Squat']")),
        _1_KM_TIMED(By.xpath("//p[text()='1 Km Timed']")),
        ARM(By.xpath("//p[text()='Arm']")),
        CHEST(By.xpath("//p[text()='Chest']")),
        WAIST(By.xpath("//p[text()='Waist']")),
        HIP(By.xpath("//p[text()='Hip']")),
        THIGH(By.xpath("//p[text()='Thigh']")),
        CALF(By.xpath("//p[text()='Calf']")),
        CUSTOM_BUTTON(By.xpath("//button[text()='Custom']"))
        ;

        Locator(By path) {
            this.path = path;
        }

        private By path;

        @Override
        public By getPath() {
            return path;
        }
    }
}
