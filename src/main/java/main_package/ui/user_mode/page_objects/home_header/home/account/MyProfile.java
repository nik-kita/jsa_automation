package main_package.ui.user_mode.page_objects.home_header.home.account;

import main_package.ui.BasePageObject;
import main_package.ui.engine.OnixLocator;
import main_package.ui.engine.OnixWebDriver;
import main_package.ui.user_mode.general_parts.Footer;
import main_package.ui.user_mode.general_parts.home.account.AccountHeader;
import main_package.ui.user_mode.general_parts.home.account.AccountSidebar;
import org.openqa.selenium.By;

public class MyProfile extends BasePageObject implements AccountHeader, AccountSidebar, Footer {
    public MyProfile(OnixWebDriver driver) {
        super(driver);
    }

    public enum Locator implements OnixLocator {
        RESET_YOUR_PASSWORD_HERE_LINK(By.cssSelector("[href=\"/users/account/reset-password\"]")),
        UPDATE_YOUR_PREFERENCES_HERE(By.cssSelector("[href=\"/emails/preferences/\"]")),
        UPLOAD_IMAGE_LITTLE_ICON_BUTTON(By.cssSelector(".uploadcare--widget__button_type_open")),
        USERNAME_INPUT(By.cssSelector("[name='username']")),
        FIRSTNAME_INPUT(By.cssSelector("[name='first_name']")),
        EMAIL_INPUT(By.cssSelector("[name='email']")),
        LASTNAME_INPUT(By.cssSelector("[name='last_name']")),
        UPDATE_DETAILS_BUTTON(By.xpath("//button[@type = 'submit'][contains(text(), 'Update Details')]")),
        FACEBOOK_CONNECT_OR_DISCONNECT(By.xpath("//div[@class = 'profile-socials__action']//form[contains(@action, 'facebook')]//button")),
        APPLE_CONNECT_OR_DISCONNECT(By.xpath("//div[@class = 'profile-socials__action']//form[contains(@action, 'apple')]//button")),

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