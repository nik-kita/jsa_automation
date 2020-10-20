package ui.specific_pages;


import org.openqa.selenium.By;
import ui.engine.OnixLocator;
import ui.engine.OnixWebDriver;

public class JsaCookies {
    OnixWebDriver driver;

    public JsaCookies(OnixWebDriver driver) {
        this.driver = driver;
    }

    public static void acceptIfCookiesPresent(OnixWebDriver driver) {
        if(!driver.checkSetting("jsacookies")) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (driver.findElements(Locator.DIALOG_BODY).size() > 0) {
                driver.findElement(Locator.OK_BUTTON).click();
                driver.setSetting("jsacookies", true);
            }
        }

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
