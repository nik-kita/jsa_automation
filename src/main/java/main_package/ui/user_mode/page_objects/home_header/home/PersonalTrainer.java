package main_package.ui.user_mode.page_objects.home_header.home;

import main_package.ui.engine.FlyTester;
import org.openqa.selenium.By;
import main_package.ui.BasePageObject;
import main_package.ui.engine.OnixLocator;
import main_package.ui.engine.OnixWebDriver;
import main_package.ui.user_mode.general_parts.home.HomeHeaderPart;

public class PersonalTrainer extends BasePageObject implements HomeHeaderPart {

    public PersonalTrainer(OnixWebDriver driver) {
        super(driver);
    }
    @Override
    public PersonalTrainer test(FlyTester flyTester) {
        flyTester.test();
        return this;
    }

    public Home clickClose() {
        driver.findElement(Locator.CLOSE_ICON).click();
        return new Home(driver);
    }

    public enum Locator implements OnixLocator {
        CLOSE_ICON(By.xpath("//div[contains(@class, 'header_two')]//img[contains(@src, 'ic_close')]")),
        INFO_ICON(By.xpath("//img[contains(@src, 'ic_info')]")),

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
