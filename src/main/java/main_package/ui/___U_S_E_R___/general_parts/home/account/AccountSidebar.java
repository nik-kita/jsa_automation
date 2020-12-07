package main_package.ui.___U_S_E_R___.general_parts.home.account;

import main_package.ui.BasePart;
import main_package.engine.OnixLocator;
import main_package.engine.OnixWebDriver;
import main_package.ui.___U_S_E_R___.page_objects.home_header.home.account.my_plan.MyPlan;
import main_package.ui.___U_S_E_R___.page_objects.home_header.home.account.my_profile.MyProfile;
import main_package.ui.___U_S_E_R___.page_objects.home_header.home.account.PairedDevices;
import main_package.ui.___U_S_E_R___.page_objects.home_header.home.account.Units;
import org.openqa.selenium.By;

public interface AccountSidebar extends BasePart {
    default MyProfile clickMyProfile() {
        OnixWebDriver driver = getDriver();
        driver.findElement(AccountSidebarLocator.MY_PROFILE).click();
        getLogger().trace("Open 'My Profile' from 'AccountSidebar'");
        return new MyProfile(driver);
    }
    default MyPlan clickMyPlan() {
        OnixWebDriver driver = getDriver();
        driver.findElement(AccountSidebarLocator.MY_PLAN_BUTTON).click();
        getLogger().trace("Open 'My Plans' from 'AccountSidebar'");
        return new MyPlan(driver);
    }
    default Units clickUnits() {
        OnixWebDriver driver = getDriver();
        driver.findElement(AccountSidebarLocator.UNITS).click();
        getLogger().trace("Open 'Units' from 'AccountSidebar'");
        return new Units(driver);
    }
    default PairedDevices clickPairedDevices() {
        OnixWebDriver driver = getDriver();
        driver.findElement(AccountSidebarLocator.PAIRED_DEVICES).click();
        getLogger().trace("Open 'PairedDevices' from 'AccountSidebar'");
        return new PairedDevices(driver);
    }




    enum AccountSidebarLocator implements OnixLocator {
        MY_PLAN_BUTTON(By.cssSelector(".account-tab-container-desktop [href=\"/users/account/my-plan\"]")),
        MY_PROFILE(By.cssSelector(".account-tab-container-desktop [href=\"/users/account/profile\"]")),
        UNITS(By.cssSelector(".account-tab-container-desktop [href=\"/users/account/units-settings\"]")),
        PAIRED_DEVICES(By.cssSelector(".account-tab-container-desktop [href=\"/users/account/fitness-tracker\"]"))

        ;
        private By path;
        AccountSidebarLocator(By path) {
            this.path = path;
        }

        @Override
        public By getPath() {
            return path;
        }
    }
}
