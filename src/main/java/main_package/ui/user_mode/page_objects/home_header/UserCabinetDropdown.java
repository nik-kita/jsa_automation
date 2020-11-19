package main_package.ui.user_mode.page_objects.home_header;


import org.openqa.selenium.By;
import main_package.ui.BasePageObject;
import main_package.ui.engine.OnixLocator;
import main_package.ui.engine.OnixWebDriver;
import main_package.ui.guest_mode.page_objects.AfterLogout;


public class UserCabinetDropdown extends BasePageObject {

    public UserCabinetDropdown(OnixWebDriver driver) {
        super(driver);
    }

    public AfterLogout logout() {
        driver.findElement(Locator.LOG_OUT).click();
        logger.debug("'AfterLogout' from 'UserCabinetDropdown'");
        return new AfterLogout(driver);
    }



    public enum Locator implements OnixLocator {
        ACCOUNT(By.cssSelector(".dropdown-menu [href='/users/account']")),
        PRICING(By.cssSelector(".dropdown-menu [href='/users/pricing/']")),
        FAQs(By.xpath("//a[contains(text(), 'FAQs')]")),
        LOG_OUT(By.cssSelector("[href='/accounts/logout']"));

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