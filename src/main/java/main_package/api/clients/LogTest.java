package main_package.api.clients;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class LogTest {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void test() {
        logger.info("Hello world!");
    }
}
