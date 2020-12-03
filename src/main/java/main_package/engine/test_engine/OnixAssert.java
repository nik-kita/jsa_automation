package main_package.engine.test_engine;

import main_package.engine.logger_engine.LogHtmlWrap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.asserts.SoftAssert;

public class OnixAssert {
    private SoftAssert softAssert;
    int softTotalCounter;
    int softSuccessCounter;
    Logger logger;

    public OnixAssert() {
        logger = new LogHtmlWrap(LoggerFactory.getLogger(this.getClass()));
        softTotalCounter = softSuccessCounter = 0;
    }

    public SoftAssert getSoftAssert() {
        if(softAssert == null) {
            softAssert = new SoftAssert();
        }
        return softAssert;
    }

    public void assertAll() {
        if(softTotalCounter == softSuccessCounter) {
            message(true, "All softAssertions passed!", "this message will never displayed");
        } else {
            message(false, "", "Not all tests passed!!!");
        }
        softAssert.assertAll();
        softAssert = null;
        softTotalCounter = softSuccessCounter = 0;
    }
    public void assertAll(String good, String bad) {
        if(softTotalCounter == softSuccessCounter) {
            message(true, good, "this message will never displayed");
        } else {
            message(false, "", bad);
        }
        softAssert.assertAll();
        softAssert = null;
        softTotalCounter = softSuccessCounter = 0;

    }

    public void message(boolean success, String good, String bad) {
        if(success) {
            logger.info("Success! " + good);
        } else {
            logger.error("Fail!!! " + bad);
        }
    }
    public void softMessage(boolean success, String good, String bad) {
        if(success) {
            logger.trace("Pass in softAssert: " + good);
            softSuccessCounter++;
            softTotalCounter++;
        } else {
            logger.error("Fail in softAssert: " + bad);
            softTotalCounter++;
        }
    }
}
