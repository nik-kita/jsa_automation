package automation;

import io.qameta.allure.Allure;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ui.OnixAssert;
import ui.OnixTestRunner;
import ui.data.User;
import ui.engine.OnixLocator;
import ui.guest_mode.page_objects.from_footer.Blog;
import ui.guest_mode.page_objects.main.Main;
import ui.guest_mode.page_objects.main.Transformations;
import ui.guest_mode.page_objects.main.login.CreateAccount;
import ui.guest_mode.page_objects.main.login.ResetPassword;
import ui.user_mode.page_objects.home_header.home.Home;
import ui.user_mode.page_objects.main.pricing.pricingplans.PaymentMethodPopup;

import java.io.FileNotFoundException;

public class WS extends OnixTestRunner {
    Main main;

    @BeforeClass
    public void startFromMainPage() {
        main = openSite();
    }

    @Test(testName = "Pricing")
    public void test_1() throws FileNotFoundException {
        allureAddMarkdownDescriptionFromFile("pricing.md");
        PaymentMethodPopup paymentMethodPopup = main
                .goLoginPage()
                .login(User.getValidUser())
                .goMainPage()
                .goPricingPage()
                .goPricingPlans()
                .subscribeStandard();
        SoftAssert softAssert = new SoftAssert();
        for (OnixLocator l : PaymentMethodPopup.Locator.values()) {
            softAssert = new OnixAssert(driver).softCheckCountOfElementByLocator(l, 1, softAssert);
        }
        paymentMethodPopup = paymentMethodPopup
                .exit()
                .subscribePremium();
        for (OnixLocator l : PaymentMethodPopup.Locator.values()) {
            softAssert = new OnixAssert(driver).softCheckCountOfElementByLocator(l, 1, softAssert);
        }
        paymentMethodPopup = paymentMethodPopup
                .exit()
                .buyNow();
        for (OnixLocator l : PaymentMethodPopup.Locator.values()) {
            softAssert = new OnixAssert(driver).softCheckCountOfElementByLocator(l, 1, softAssert);
        }
        main = paymentMethodPopup
                .exit()
                .clickLogoutHeaderButton()
                .goMainPage();
        softAssert.assertAll();
    }

    @Test(testName = "Transformations")
    public void test_2() {
        allureAddTxtFileAttachment("transformations.txt");
        Transformations transformations = main
                .clickSeeMoreTransformationsButton();
        SoftAssert softAssert = new SoftAssert();
        int before = Integer.MIN_VALUE;
        while (transformations.seeMore()) {
            int current = transformations.countTransformations();
            softAssert = new OnixAssert(driver).softCheckFirstGreaterSecond(current, before, softAssert);
            System.out.println(before + "  " + current);
            before = current;
        }
        main = transformations.goMainPage();
        softAssert.assertAll();
    }

    @Test(testName = "Blog")
    public void test_3() {
        Allure.link("https://docs.google.com/spreadsheets/d/1gudjZ7fh4aUsozP7aPIovLnI4qGdbUFpIHJ6AbTlbC4/edit?usp=sharing");
        Blog blog = main.goBlogPageFromFooter();
        int total = blog.countPosts();
        int fromEveryTab = 0;
        for (OnixLocator l : Blog.Locator.values()) {
            driver.findElement(l).click();
            fromEveryTab += blog.countPosts();
        }
        fromEveryTab -= total;
        main = blog.goMainPage();
        new OnixAssert(driver).checkCount(total, fromEveryTab);
    }

    @Test(testName = "Login")
    public void test_4() {
        SoftAssert softAssert = new SoftAssert();
        Home home = main.goLoginPage().login(User.getValidUser());
        softAssert = new OnixAssert(driver)
                .softCheckCountOfElementByLocator(Home.Locator.CHALLENGE_DIV_LINK, 1, softAssert);
        main = home.openUserDropDown().logout().goMainPage();
        ResetPassword resetPassword = main.goLoginPage().clickForgotPassword();
        softAssert = new OnixAssert(driver)
                .softCheckCountOfElementByLocator(ResetPassword.Locator.EMAIL_INPUT, 1, softAssert);
        main = resetPassword.goMainPage();
        home = main.goLoginPage().loginByFB(User.getValidUser());
        softAssert = new OnixAssert(driver)
                .softCheckCountOfElementByLocator(Home.Locator.CHALLENGE_DIV_LINK, 1, softAssert);
        main = home.openUserDropDown().logout().goMainPage();
        CreateAccount createAccount = main.clickGetStartedButton();
        softAssert = new OnixAssert(driver)
                .softCheckCountOfElementByLocator(CreateAccount.Locator.CREATE_ACCOUNT_BUTTON, 1, softAssert);
        main = createAccount.goMainPage();
        softAssert.assertAll();
    }
}
