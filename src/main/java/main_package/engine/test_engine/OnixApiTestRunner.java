package main_package.engine.test_engine;

import main_package.api.clients.UserClient;
import main_package.api.models.User;
import main_package.engine.logger_engine.LogHtmlWrap;
import main_package.engine.test_engine.OnixTestRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;

public class OnixApiTestRunner extends OnixTestRunner {
    protected UserClient userClient;
    protected User user;
    Logger logger;

    @BeforeClass
    public void beforeClass() {
        user = User.getValidApiUser();
        userClient = new UserClient(user);
        logger = new LogHtmlWrap(LoggerFactory.getLogger(this.getClass()));
    }


}
