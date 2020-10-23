package ui.user_mode.page_objects.home_header.home.my_goal;

import org.openqa.selenium.By;
import ui.BasePageObject;
import ui.engine.OnixLocator;
import ui.engine.OnixWebDriver;

public class NewWeeklyGoal extends BasePageObject {

    public NewWeeklyGoal(OnixWebDriver driver) {
        super(driver);
    }
    public MyGoal clickCloseButton() {
        driver.findElement(Locator.CLOSE_X_BUTTON).click();
        return new MyGoal(driver);
    }
    public MyGoal save(String text) {
        driver.findElement(Locator.GAOL_TEXTAREA).sendKeys(text);
        driver.findElement(Locator.SAVE_BUTTON).click();
        return new MyGoal(driver);
    }



    public enum Locator implements OnixLocator {
        CLOSE_X_BUTTON(By.xpath("//button//img[contains(@src, 'close')]")),
        GAOL_TEXTAREA(By.cssSelector("textarea[name='goal']")),
        SAVE_BUTTON(By.xpath("//div[@class='modal-window']//button[text()='Save']")),

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
