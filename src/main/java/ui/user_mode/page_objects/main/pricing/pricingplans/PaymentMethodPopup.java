package ui.user_mode.page_objects.main.pricing.pricingplans;


import org.openqa.selenium.By;
import ui.engine.OnixLocator;
import ui.engine.OnixWebDriver;

public class PaymentMethodPopup {
    public OnixWebDriver driver;
    String PAYPAL_IFRAME_NAME;


    public PaymentMethodPopup(OnixWebDriver driver) {
        this.driver = driver;
    }

    public PricingPlans exit() {

        driver.waitToClick(Locator.EXIT_X_BUTTON).click();
        driver.waitInvisibilityOf(Locator.EXIT_X_BUTTON);
        return new PricingPlans(driver);
    }

    public void clickPayWithCard() {
        driver.findElement(Locator.PAY_WITH_CARD_BUTTON).click();
    }

    public PaymentMethodPopup clickPayPalTab() {
        driver.findElement(Locator.PAY_PALL_TAB).click();
        PAYPAL_IFRAME_NAME = driver
                .getSeleniumDriver()
                .findElement(By.xpath("//iframe"))
                .getAttribute("name");
        System.out.println(PAYPAL_IFRAME_NAME);
        return this;
    }
    public PaymentMethodPopup clickCardTab() {
        driver.findElement(Locator.CARD_TAB).click();
        return this;
    }

    public PayPalIframe switchToPayPalIframe() {
        if(PAYPAL_IFRAME_NAME == null) {
            clickPayPalTab();
        }
        driver.getSeleniumDriver().switchTo().frame(PAYPAL_IFRAME_NAME);
        return new PayPalIframe(driver);
    }


    public enum Locator implements OnixLocator {
        EXIT_X_BUTTON(By.xpath("(//span[contains(text(), '×')])[1]")),
        PAY_PALL_TAB(By.id("nav-paypal-tab")),
        CARD_TAB(By.id("nav-card-tab")),
        PAY_WITH_CARD_BUTTON(By.xpath("//button[contains(text(), 'Pay with Card')]")),

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
    public enum PayPalIframeLocator implements OnixLocator {
        PAYPAL_BTN_IN_PAYPAL_IFRAME(By.xpath("//div[@class='paypal-button-label-container']//img[@aria-label='PayPal']")),
        DEBIT_OR_CREDIT_BTN_IN_PAYPAL_IFRAME(By.xpath("//*[@class='paypal-button-label-container']//span[contains(text(), 'Debit or Credit')]")),

        ;

        private By path;

        PayPalIframeLocator(By path) {
            this.path = path;
        }
        @Override
        public By getPath() {
            return path;
        }

    }

    public class PayPalIframe {
        OnixWebDriver driver;
        public PayPalIframe(OnixWebDriver driver) {
            this.driver = driver;
        }
        public void clickPayPalButton() {

            driver.findElement(PayPalIframeLocator.PAYPAL_BTN_IN_PAYPAL_IFRAME).click();
        }

        public void clickDebitOrCreditCard() {

            driver.findElement(PayPalIframeLocator.DEBIT_OR_CREDIT_BTN_IN_PAYPAL_IFRAME).click();
        }

        public PaymentMethodPopup clickCardTab() {
            driver.toParentFrame();
            return new PaymentMethodPopup(driver);
        }


    }

}
