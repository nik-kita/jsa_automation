package ui.shortcuts;


import ui.BasePageObject;
import ui.data.User;
import ui.engine.OnixWebDriver;
import ui.guest_mode.page_objects.main.login.Login;
import ui.user_mode.page_objects.home_header.home.Home;

public class RouteHacks extends BasePageObject {
    OnixWebDriver driver;
    String loginEndPoint = "users/login/";

    public RouteHacks(OnixWebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public Home login(String nameOrEmail, String password) {
        String urlForLogin = driver.getSeleniumDriver().getCurrentUrl() + loginEndPoint;
        driver.get(urlForLogin);
        Login loginPO = new Login(driver);
        User user = new User(nameOrEmail, password);
        logger.debug("go 'Login' by simply use '" + loginEndPoint + "' endpoint in url");
        return loginPO.login(user);
    }
    public Home login(User user) {
        String urlForLogin = driver.getSeleniumDriver().getCurrentUrl() + loginEndPoint;
        driver.get(urlForLogin);
        Login loginPO = new Login(driver);
        logger.debug("go 'Login' by simply use '" + loginEndPoint + "' endpoint in url");
        return loginPO.login(user);
    }
    public Home login() {
        String urlForLogin = driver.getSeleniumDriver().getCurrentUrl() + loginEndPoint;
        driver.get(urlForLogin);
        logger.debug("go 'Login' by simply use '" + loginEndPoint + "' endpoint in url");
        return new Login(driver).login(User.getValidUser());
    }
}
