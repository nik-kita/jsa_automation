package main_package.ui.specific;

import main_package.engine.test_engine.FlyTester;
import org.slf4j.Logger;
import main_package.engine.OnixWebDriver;

public abstract class BaseSpecific {
    OnixWebDriver driver;
    Logger logger;
    public BaseSpecific(OnixWebDriver driver, Logger logger) {
        this.logger = logger;
        this.driver = driver;
    }
    public abstract BaseSpecific test(FlyTester flyTester);
}
