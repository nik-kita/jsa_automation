package ui.specific;

import org.openqa.selenium.By;
import ui.BasePageObject;
import ui.engine.OnixLocator;
import ui.engine.OnixWebDriver;
import ui.specific.JsaCookies;

public class AppBanner {
    OnixWebDriver driver;

    public AppBanner(OnixWebDriver driver) {
        this.driver = driver;
    }

    public static void closeIfPresent(OnixWebDriver driver) {
        if(!driver.checkSetting("appBannerClosed")) {
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            if (driver.isElementPresent(Locator.BANNER_CONTAINER)) {
                driver.findElement(Locator.CLOSE_UP_CORNER_BUTTON).click();
                driver.setSetting("appBannerClosed", true);
            }
        }
    }
    public enum Locator implements OnixLocator {
        BANNER_CONTAINER(By.cssSelector(".banner_container")),
        CLOSE_UP_CORNER_BUTTON(By.cssSelector(".banner_container__close a")),


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
