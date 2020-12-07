package main_package.ui.guest_mode.page_objects.main.login;

import main_package.engine.OnixLocator;
import main_package.engine.OnixWebDriver;
import main_package.engine.test_engine.FlyTester;
import main_package.engine.test_engine.OnixUiAssert;
import main_package.ui.BasePageObject;
import main_package.ui.___U_S_E_R___.page_objects.home_header.home.Home;
import org.openqa.selenium.By;

public class FbWindowForLogin extends BasePageObject {
    public FbWindowForLogin(OnixWebDriver driver) {
        super(driver);
        this.driver = driver;
        logger.debug("'Facebook window for login' is open.");
    }
    public FbWindowForLogin check(OnixUiAssert onixUiAssert) {
        for(OnixLocator l : OnixUiAssert.mergeArrays(
                FbWindowForLogin.Locator.values()
        )) {
            onixUiAssert.softCheckCountOfElementByLocator(l, 1);
        }
        return this;
    }

    @Override
    public FbWindowForLogin test(FlyTester flyTester) {
        flyTester.test();
        return this;
    }

    public enum Locator implements OnixLocator {
        EMAIL_OR_NUMBER_INPUT(By.xpath("//input[@id='email']")),
        PASSWORD_INPUT(By.xpath("//input[@type='password']")),
        LOG_IN_BUTTON(By.cssSelector("#loginbutton"))

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
    OnixLocator confirmButton = makeOnixLocator(By.xpath("//button[@name='__CONFIRM__']"), this.getClass());

    public Home login(String name, String password) {
        driver.findElement(Locator.EMAIL_OR_NUMBER_INPUT).sendKeys(name);
        driver.findElement(Locator.PASSWORD_INPUT).sendKeys(password);
        driver.findElement(Locator.LOG_IN_BUTTON).click();
        if(driver.isElementPresent(confirmButton)) {
            logger.debug("additional facebook page for confirmation is present");
            driver.waitToClick(confirmButton).click();
        }
        OnixLocator firstCheckNameInput = makeOnixLocator(By.xpath("//input[contains(@value, ' ')]"), Home.class);
        OnixLocator firstCheckTermsCheckbox = makeOnixLocator(By.cssSelector(".checkbox #terms-styler"), Home.class);
        OnixLocator firstCheckCreateAccountButton = makeOnixLocator(By.cssSelector("input[type='submit']"), Home.class);
        if(driver.isElementPresent(firstCheckNameInput)) {
            driver.waitToClick(firstCheckTermsCheckbox).click();
            driver.waitToClick(firstCheckCreateAccountButton).click();
            logger.debug("additional first name checking page is present");
        }
        logger.debug("'Home' from 'FB'");
        return new Home(driver);
    }
}
