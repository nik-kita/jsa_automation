package main_package.ui.user_mode.page_objects.home_header.home.account.my_plan;

import main_package.ui.BasePageObject;
import main_package.engine.test_engine.FlyTester;
import main_package.engine.OnixLocator;
import main_package.engine.OnixWebDriver;
import org.openqa.selenium.By;

public class UpdateCardPopup extends BasePageObject {
    String iFrameCardInputName;
    public UpdateCardPopup(OnixWebDriver driver) {
        super(driver);
        iFrameCardInputName = driver.findElement(Locator.CARD_NUMBER_INPUT_IFRAME).getSeleniumWebElement().getAttribute("name");
    }
    @Override
    public UpdateCardPopup test(FlyTester flyTester) {
        flyTester.test();
        return this;
    }

    public MyPlan close() {
        driver.waitToClick(Locator.CLOSE_BUTTON).click();
        return new MyPlan(driver);
    }
    public enum Locator implements OnixLocator {
        EMAIL_INPUT(By.cssSelector("input#email")),
        CARD_NUMBER_INPUT_IFRAME(By.xpath("//iframe[contains(@name, 'privateStripeFrame')]")),
        NAME_ON_CARD_INPUT(By.cssSelector("input#customer_name")),
        UPDATE_CARD_BUTTON(By.cssSelector("button#submitPaymentButton")),
        CLOSE_BUTTON(By.cssSelector("#updateCardModal button.close span")),

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

    class CardInputIframe extends BasePageObject {
        public CardInputIframe(OnixWebDriver driver) {
            super(driver);
        }
        @Override
        public BasePageObject test(FlyTester flyTester) {
            flyTester.test();
            return this;
        }
    }
}
