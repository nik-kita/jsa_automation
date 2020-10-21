package ui.user_mode.main.pricing;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ui.OnixAssert;
import ui.engine.OnixLocator;
import ui.user_mode.JsaLoginBaseTestRunner;
import ui.user_mode.page_objects.main.pricing.pricingplans.PaymentMethodPopup;

public class PaymentMethodPopupTest extends JsaLoginBaseTestRunner {
    PaymentMethodPopup paymentMethodPopup;

    @BeforeClass
    public void openPopup() {
        paymentMethodPopup = homeLoginModePO
                .goMainPage()
                .goPricingPage()
                .goPricingPlans()
                .subscribePremium();
    }

    @Test(dataProvider = "getPaymentMethodCardLocators")
    public void paymentMethodCardTest(OnixLocator locator) {

        paymentMethodPopup.clickCardTab();

        new OnixAssert(driver).checkCountOfElementByLocator(locator, 1);
    }

    @DataProvider
    public Object[] getPaymentMethodCardLocators() {
        return PaymentMethodPopup.Locator.values();
    }

    @Test(dataProvider = "getPaymentMethodPayPalLocators")
    public void paymentMethodPayPalTest(OnixLocator locator) {
        PaymentMethodPopup.PayPalIframe frame = paymentMethodPopup.switchToPayPalIframe();
        SoftAssert soft = new SoftAssert();
        new OnixAssert(driver).softCheckCountOfElementByLocator(locator, 1, soft);
        paymentMethodPopup = frame.clickCardTab();
        soft.assertAll();
    }

    @DataProvider
    public Object[] getPaymentMethodPayPalLocators() {
        return PaymentMethodPopup.PayPalIframeLocator.values();
    }
}
