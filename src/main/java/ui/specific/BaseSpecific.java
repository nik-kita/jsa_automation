package ui.specific;

import org.slf4j.Logger;
import ui.engine.OnixWebDriver;

public class BaseSpecific {
    OnixWebDriver driver;
    Logger logger;
    public BaseSpecific(OnixWebDriver driver, Logger logger) {
        this.logger = logger;
        this.driver = driver;
    }
}
