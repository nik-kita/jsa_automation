package ui.user_mode.general_parts.home.account;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import ui.BasePart;
import ui.engine.OnixLocator;
import ui.engine.OnixWebDriver;
import ui.guest_mode.page_objects.AfterLogout;
import ui.user_mode.page_objects.home_header.home.Account;
import ui.user_mode.page_objects.home_header.home.Home;
import ui.user_mode.page_objects.main.Main;
import ui.user_mode.page_objects.main.pricing.pricingplans.PricingPlans;

public interface AccountHeader extends BasePart {

    default Home clickHomeHeaderButton() {
        OnixWebDriver onixWebDriver = getDriver();
        onixWebDriver.findElement(AccountHeaderLocator.HOME_HEADER_BUTTON).click();
        getLogger().debug("'Home' from header");
        return new Home(onixWebDriver);
    }
    default Main clickJsaHeaderLogo() {
        OnixWebDriver driver = getDriver();
        driver.findElement(AccountHeaderLocator.JSA_LOGO).click();
        getLogger().debug("'Main' from header");
        return new Main(driver);
    }
    default Account clickAccountHeaderButton() {
        OnixWebDriver driver = getDriver();
        driver.findElement(AccountHeaderLocator.ACCOUNT_HEADER_BUTTON).click();
        getLogger().debug("'Account' from header");
        return new Account(driver);
    }
    default PricingPlans clickPricingPlansHeaderButton() {
        OnixWebDriver driver = getDriver();
        driver.findElement(AccountHeaderLocator.PRICING_PLANS_HEADER_BUTTON).click();
        getLogger().debug("'PricingPlans' from header");
        return new PricingPlans(driver);
    }
    default AfterLogout clickLogoutHeaderButton() {
        OnixWebDriver driver = getDriver();
        driver.findElement(AccountHeaderLocator.LOGOUT_HEADER_BUTTON).click();
        getLogger().debug("'AfterLogout' from header");
        return new AfterLogout(driver);
    }



    enum AccountHeaderLocator implements OnixLocator {
        JSA_LOGO(By.cssSelector(".main-header [href='/']")),
        HOME_HEADER_BUTTON(By.cssSelector(".nav [href='/users/']")),
        ACCOUNT_HEADER_BUTTON(By.cssSelector(".nav [href='/users/account/']")),
        PRICING_PLANS_HEADER_BUTTON(By.cssSelector(".nav [href='/users/pricing/']")),
        LOGOUT_HEADER_BUTTON(By.xpath("//div[@class='nav']//a[contains(text(), 'Logout')]"))

        ;
        private By path;
        AccountHeaderLocator(By path) {
            this.path = path;
        }

        @Override
        public By getPath() {
            return path;
        }
    }
}
