package ui.user_mode.page_objects.home_header.home.my_progress;

import org.openqa.selenium.By;
import ui.BasePageObject;
import ui.engine.OnixLocator;
import ui.engine.OnixWebDriver;
import ui.user_mode.general_parts.home.HomeHeaderPart;
import ui.user_mode.page_objects.home_header.home.Home;
import ui.user_mode.page_objects.home_header.home.my_progress.measurements_tab.MeasurementsTab;

public class MyProgress extends BasePageObject implements HomeHeaderPart {
    public MyProgress(OnixWebDriver driver) {
        super(driver);
    }

    public Home clickBackArrow() {
        driver.findElement(Locator.BACK_HOME_ARROW).click();
        return new Home(driver);
    }

    public MeasurementsTab clickMeasurementsTab() {
        driver.findElement(Locator.MEASUREMENTS_TAB_BUTTON).click();
        return new MeasurementsTab(driver);
    }

    public enum Locator implements OnixLocator {
        BACK_HOME_ARROW(By.xpath("//a[@href='#/home']/img")),
        MEASUREMENTS_TAB_BUTTON(By.xpath("//a[text()='Measurements']")),
        IMAGES_TAB_BUTTON(By.xpath("//a[text()='Images']")),

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
