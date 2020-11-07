package ui;

import io.qameta.allure.Allure;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.slf4j.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class MyTest {

    @BeforeClass
    public void bc() {
        System.err.println("before class");

    }
    @BeforeSuite
    public void bs() {
        System.err.println("before suite");
    }

    Marker testName = MarkerFactory.getMarker("test name");
    Marker testLink = MarkerFactory.getMarker("test link");
    Marker finishhTest = MarkerFactory.getMarker("test finish");

    @Test
    public void t() throws IOException {
        Logger logger = LoggerFactory.getLogger(this.getClass());
        logger.info(testLink, "11111111111111111111111111111111111111111111111111111111111111111");
        logger.debug(testName, "2222222222222222222222222222222222222222222222222222222222222222");
        logger.trace("33333333333333333333333333333333333333333333333333333333333333333333333333");
        logger.info("444444444444444444444444444444444444444444444444444444444444444444444444444");
        MDC.put("test", "hello world");
        logger.info("555555555555555555555555555555555555555555555555555555555555555555555555555");
        logger.info("666666666666666666666666666666666666666666666666666666666666666666666666666");
        logger.trace("77777777777777777777777777777777777777777777777777777777777777777777777777");
        logger.error(finishhTest, "8888888888888888888888888888888888888888888888888888888888888");
        logger.error("8888888888888888888888888888888888888888888888888888888888888");
        MDC.remove("test");
        logger.error("8888888888888888888888888888888888888888888888888888888888888");
        logger.error("8888888888888888888888888888888888888888888888888888888888888");
        logger.error("8888888888888888888888888888888888888888888888888888888888888");
        MDC.put("test", "ok google");
        logger.warn("999999999999999999999999999999999999999999999999999999999999999999999999999");

        try {

            int i = 4 / 0;
        } catch (Exception e) {
            logger.error("10 Boom!", e);
        }

        logger.error("11 11 11");
        logger.info("12 12 12");
        logger.error("13 13 13");
        logger.error(finishhTest, "Good luck!");
    }
}
