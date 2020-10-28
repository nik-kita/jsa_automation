package ui;

import org.slf4j.Logger;
import ui.engine.OnixWebDriver;

public interface BasePart {
    Logger getLogger();
    OnixWebDriver getDriver();
}
