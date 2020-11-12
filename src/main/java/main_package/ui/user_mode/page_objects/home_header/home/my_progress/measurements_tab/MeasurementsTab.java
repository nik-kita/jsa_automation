package main_package.ui.user_mode.page_objects.home_header.home.my_progress.measurements_tab;

import org.openqa.selenium.By;
import main_package.ui.BasePageObject;
import main_package.ui.engine.OnixLocator;
import main_package.ui.engine.OnixWebDriver;
import main_package.ui.user_mode.general_parts.home.HomeHeaderPart;

public class MeasurementsTab extends BasePageObject implements HomeHeaderPart {
    public MeasurementsTab(OnixWebDriver driver) {
        super(driver);
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
