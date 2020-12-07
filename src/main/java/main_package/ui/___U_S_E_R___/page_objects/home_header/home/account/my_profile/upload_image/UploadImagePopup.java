package main_package.ui.___U_S_E_R___.page_objects.home_header.home.account.my_profile.upload_image;

import main_package.ui.BasePart;
import main_package.engine.OnixLocator;
import main_package.engine.OnixWebDriver;
import main_package.ui.___U_S_E_R___.page_objects.home_header.home.account.my_profile.MyProfile;
import org.openqa.selenium.By;

public interface UploadImagePopup extends BasePart {
    default MyProfile close() {
        OnixWebDriver driver = getDriver();
        driver.waitToClick(UploadImagePopupLocator.CLOSE).click();
        return new MyProfile(driver);
    }

    enum UploadImagePopupLocator implements OnixLocator {
        CLOSE(By.cssSelector(".uploadcare--dialog__close")),

        ;
        private By path;
        UploadImagePopupLocator(By path) {
            this.path = path;
        }

        @Override
        public By getPath() {
            return path;
        }
    }

}
