package ui.specific;


import org.openqa.selenium.By;
import org.slf4j.Logger;
import ui.BasePart;
import ui.BaseStatic;
import ui.engine.OnixLocator;
import ui.engine.OnixWebDriver;

public class JsaCookies extends BaseSpecific implements BasePart {

    public JsaCookies(OnixWebDriver driver, Logger logger) {
        super(driver, logger);
    }

    public OnixWebDriver acceptIfCookiesPresent() {
        if(!driver.checkSetting("jsacookies")) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (driver.findElements(Locator.DIALOG_BODY).size() > 0) {
                driver.waitToClick(Locator.OK_BUTTON).click();
                driver.setSetting("jsacookies", true);
                logger.debug("close 'JsaCookies' popup");
            }
            logger.warn("try to close 'JsaCookies' popup but no such elements was found");
        }
        logger.trace("try close 'JsaCookies' popup but it is already done");
        return driver;
    }

    @Override
    public Logger getLogger() {
        return logger;
    }

    @Override
    public OnixWebDriver getDriver() {
        return driver;
    }

    public enum Locator implements OnixLocator {
        DIALOG_BODY(By.cssSelector("#CybotCookiebotDialog")),
        OK_BUTTON(By.cssSelector("#CybotCookiebotDialogBodyLevelButtonAccept")),

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

}
