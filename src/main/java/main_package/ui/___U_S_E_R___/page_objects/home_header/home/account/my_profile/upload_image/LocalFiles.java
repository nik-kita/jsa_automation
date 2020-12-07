package main_package.ui.___U_S_E_R___.page_objects.home_header.home.account.my_profile.upload_image;

import main_package.ui.BasePageObject;
import main_package.engine.test_engine.FlyTester;
import main_package.engine.OnixWebDriver;

public class LocalFiles extends BasePageObject implements UploadImagePopup {
    public LocalFiles(OnixWebDriver driver) {
        super(driver);
    }
    @Override
    public LocalFiles test(FlyTester flyTester) {
        flyTester.test();
        return this;
    }
}
