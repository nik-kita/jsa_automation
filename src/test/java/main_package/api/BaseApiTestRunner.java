package main_package.api;

import io.restassured.response.Response;
import main_package.api.clients.UserClient;
import main_package.api.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BaseApiTestRunner {
    UserClient userClient;
    User user;
    Logger logger;
    String token;

    @BeforeClass
    public void beforeClass() {
        userClient = new UserClient();
        user = User.getValidUser();
        logger = LoggerFactory.getLogger(this.getClass());
        token = userClient.generateToken(user);
    }

    @Test
    public void test() {
        System.out.println(token);
    }

}
