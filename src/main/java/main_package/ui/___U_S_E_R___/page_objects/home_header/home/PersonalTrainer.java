package main_package.ui.___U_S_E_R___.page_objects.home_header.home;

import main_package.engine.test_engine.FlyTester;
import org.openqa.selenium.By;
import main_package.ui.BasePageObject;
import main_package.engine.OnixLocator;
import main_package.engine.OnixWebDriver;
import main_package.ui.___U_S_E_R___.general_parts.home.HomeHeaderPart;

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
