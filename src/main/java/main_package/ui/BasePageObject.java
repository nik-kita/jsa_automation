package main_package.ui;

import main_package.engine.test_engine.FlyTester;
import main_package.engine.test_engine.OnixUiTestRunner;
import main_package.ui.guest_mode.page_objects.main.Main;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import main_package.engine.OnixLocator;
import main_package.engine.OnixWebDriver;
import main_package.ui.specific.JsaCookies;

public abstract class BasePageObject {
    protected OnixWebDriver driver;
    public Logger logger;

    public BasePageObject(OnixWebDriver driver) {
        logger = LoggerFactory.getLogger(this.getClass());
        this.driver = new JsaCookies(driver, logger).acceptIfCookiesPresent();
    }
    public OnixLocator makeOnixLocator(By path, Class<?> from) {
        return new OnixLocator() {
            @Override
            public By getPath() {
                return path;
            }

            @Override
            public String name() {
                return "Class: " + from.getName() + "\nLocator: " + path.toString();
            }
        };
    }

    public Logger getLogger() {
        return logger;
    }

    public OnixWebDriver getDriver() {
        return driver;
    }

    public abstract BasePageObject test(FlyTester flyTester);
    public Main openFromScratch() {
        driver.get(OnixUiTestRunner.baseUrl);
        return new Main(driver);
    }
}
