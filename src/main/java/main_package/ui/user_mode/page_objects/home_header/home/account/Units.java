package main_package.ui.user_mode.page_objects.home_header.home.account;

import main_package.ui.BasePageObject;
import main_package.ui.engine.FlyTester;
import main_package.ui.engine.OnixLocator;
import main_package.ui.engine.OnixWebDriver;
import main_package.ui.user_mode.general_parts.Footer;
import main_package.ui.user_mode.general_parts.home.account.AccountHeader;
import main_package.ui.user_mode.general_parts.home.account.AccountSidebar;
import org.openqa.selenium.By;

public class Units extends BasePageObject implements AccountHeader, AccountSidebar, Footer {


    public Units(OnixWebDriver driver) {
        super(driver);
    }
    @Override
    public Units test(FlyTester flyTester) {
        flyTester.test();
        return this;
    }

    public enum Locator implements OnixLocator {
        METRIC_WEIGHT_UNIT(By.cssSelector("[value='Metric (kg)']")),
        IMPERIAL_WEIGHT_UNIT(By.cssSelector("[value='Imperial (lbs)']")),
        METRIC_LENGTH_UNIT(By.cssSelector("[value=\"Metric (cm)\"]")),
        IMPERIAL_LENGTH_UNIT(By.cssSelector("[value=\"Imperial (in)\"]")),
        METRIC_DISTANCE_UNIT(By.cssSelector("[value=\"Metric (m/km)\"]")),
        IMPERIAL_DISTANCE_UNIT(By.cssSelector("[value=\"Imperial (ft/miles)\"]")),
        UPDATE_UNITS_BUTTON(By.xpath("//button[text() = 'Update Units']"))
        ;

        private By path;

        Locator(By path) {
            this.path = path;
        }

        @Override
        public By getPath() {
            return path;
        }
    }
}
