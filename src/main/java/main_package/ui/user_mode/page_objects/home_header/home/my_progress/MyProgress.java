package main_package.ui.user_mode.page_objects.home_header.home.my_progress;

import main_package.engine.test_engine.FlyTester;
import org.openqa.selenium.By;
import main_package.ui.BasePageObject;
import main_package.engine.OnixLocator;
import main_package.engine.OnixWebDriver;
import main_package.ui.user_mode.general_parts.home.HomeHeaderPart;
import main_package.ui.user_mode.page_objects.home_header.home.Home;
import main_package.ui.user_mode.page_objects.home_header.home.my_progress.measurements_tab.MeasurementsTab;

public class MyProgress extends BasePageObject implements HomeHeaderPart {
    public MyProgress(OnixWebDriver driver) {
        super(driver);
    }

    public Home clickBackArrow() {
        driver.findElement(Locator.BACK_HOME_ARROW).click();
        return new Home(driver);
    }
    @Override
    public MyProgress test(FlyTester flyTester) {
        flyTester.test();
        return this;
    }

    public MeasurementsTab clickMeasurementsTab() {
        driver.findElement(Locator.MEASUREMENTS_TAB_BUTTON).click();
        return new MeasurementsTab(driver);
    }

    public ImagesTab clickImagesTab() {
        driver.findElement(Locator.IMAGES_TAB_BUTTON).click();
        return new ImagesTab(driver);
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
