package main_package.api;

import main_package.api.clients.UserClient;
import main_package.api.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;

public class BaseApiTestRunner {
    UserClient userClient;
    User user;
    Logger logger;

    @BeforeClass
    public void beforeClass() {
        user = User.getValidApiUser();
        userClient = new UserClient(user);
        logger = LoggerFactory.getLogger(this.getClass());
    }


}
