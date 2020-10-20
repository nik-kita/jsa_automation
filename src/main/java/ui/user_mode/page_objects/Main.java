package ui.user_mode.page_objects;


import ui.BasePageObject;
import ui.engine.OnixWebDriver;
import ui.user_mode.general_parts.Footer;
import ui.user_mode.general_parts.MainHeader;

public class Main extends BasePageObject implements Footer, MainHeader {
    public Main(OnixWebDriver driver) {
        super(driver);
    }

    public Home goHome() {
        driver.findElement(HeaderLocator.TO_USER_HOME_CORNER_LINK).click();
        return new Home(driver);
    }


}
