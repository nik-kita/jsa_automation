package main_package.ui.___U_S_E_R___.general_parts.home;

import main_package.engine.OnixLocator;
import main_package.engine.OnixWebDriver;
import main_package.ui.___U_S_E_R___.page_objects.home_header.home.PersonalTrainer;
import org.openqa.selenium.By;

public interface HomePart extends HomeHeader {

    default PersonalTrainer clickSupportButton() {
        OnixWebDriver driver = getDriver();
        driver.findElement(HomeFlyLocator.SUPPORT_BUTTON).click();
        return new PersonalTrainer(driver);
    }

    enum HomeFlyLocator implements OnixLocator {
        SUPPORT_BUTTON(By.xpath("//button[contains(text(), 'Support')]")),

        ;

        private By path;

        HomeFlyLocator(By path) {
            this.path = path;
        }
        @Override
        public By getPath() {
            return path;
        }



    }
}