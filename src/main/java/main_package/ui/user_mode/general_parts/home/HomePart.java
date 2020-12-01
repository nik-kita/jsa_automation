package main_package.ui.user_mode.general_parts.home;

import main_package.engine.OnixLocator;
import main_package.engine.OnixWebDriver;
import main_package.ui.user_mode.page_objects.home_header.home.PersonalTrainer;
import org.openqa.selenium.By;

public interface HomePart extends HomeHeaderPart {

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
