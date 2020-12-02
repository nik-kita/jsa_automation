package test_package.unit.user_mode.main.pricing.pricingplans;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.engine.test_engine.OnixUiAssert;
import main_package.engine.OnixLocator;
import main_package.ui.user_mode.JsaLoginBaseUiTestRunner;
import main_package.ui.user_mode.page_objects.main.pricing.pricingplans.PaymentMethodPopup;

public class PaymentMethodPopupUiTest extends JsaLoginBaseUiTestRunner {
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

        new OnixUiAssert(driver).checkCountOfElementByLocator(locator, 1);
    }

    @DataProvider
    public Object[] getPaymentMethodCardLocators() {
        return PaymentMethodPopup.Locator.values();
    }

    @Test(dataProvider = "getPaymentMethodPayPalLocators")
    public void paymentMethodPayPalTest(OnixLocator locator) {
        PaymentMethodPopup.PayPalIframe frame = paymentMethodPopup.switchToPayPalIframe();
        onixUiAssert.softCheckCountOfElementByLocator(locator, 1);
        paymentMethodPopup = frame.clickCardTab();
        onixUiAssert.assertAll();
    }

    @DataProvider
    public Object[] getPaymentMethodPayPalLocators() {
        return PaymentMethodPopup.PayPalIframeLocator.values();
    }
}
