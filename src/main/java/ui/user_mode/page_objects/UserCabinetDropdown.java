package ui.user_mode.page_objects;


import org.openqa.selenium.By;
import ui.BasePageObject;
import ui.engine.OnixLocator;
import ui.engine.OnixWebDriver;
import ui.guest_mode.page_objects.AfterLogout;


public class UserCabinetDropdown extends BasePageObject {
    public UserCabinetDropdown(OnixWebDriver driver) {
        super(driver);
    }

    public AfterLogout logout() {
        driver.findElement(Locator.LOG_OUT).click();
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
