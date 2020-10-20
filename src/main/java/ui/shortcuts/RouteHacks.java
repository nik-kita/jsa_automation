package ui.shortcuts;


import ui.BasePageObject;
import ui.data.User;
import ui.engine.OnixWebDriver;
import ui.guest_mode.page_objects.Login;
import ui.user_mode.page_objects.Home;

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
        return loginPO.login(user);
    }
    public Home login(User user) {
        String urlForLogin = driver.getSeleniumDriver().getCurrentUrl() + loginEndPoint;
        driver.get(urlForLogin);
        Login loginPO = new Login(driver);
        return loginPO.login(user);
    }
    public Home login() {
        String urlForLogin = driver.getSeleniumDriver().getCurrentUrl() + loginEndPoint;
        driver.get(urlForLogin);
        return new Login(driver).login(User.getValidUser());
    }
}
