package ui;


import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ui.data.User;

public class MyTest extends OnixTestRunner {

    @Test(testName = "Pricing (WS)")
    public void test_2() {

        int iframes = driver.getSeleniumDriver().findElements(By.cssSelector("div#nav-paypal>div[style='display: block;']")).size();

    }


    @Test
    public void test_3() {
        openSite().goLoginPage()
                .login(User.getValidUser())
                .goMainPage()
                .goPricingPage()
                .goPricingPlans()
                .subscribePremium();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
