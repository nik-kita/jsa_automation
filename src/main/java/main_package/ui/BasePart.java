package main_package.ui;

import org.slf4j.Logger;
import main_package.ui.engine.OnixWebDriver;

public interface BasePart {
    Logger getLogger();
    OnixWebDriver getDriver();
}
