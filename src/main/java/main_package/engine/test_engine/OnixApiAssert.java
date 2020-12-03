package main_package.engine.test_engine;

import io.restassured.response.Response;
import main_package.engine.logger_engine.CssInTag;
import main_package.engine.logger_engine.Tag;
import org.testng.Assert;

public class OnixApiAssert extends OnixAssert {
    public OnixApiAssert softCheckStatusCode(int actual, int expected) {
        getSoftAssert().assertEquals(actual, expected);
        softMessage(
                actual == expected,
                "Correct Status Code (" + actual + ")",
                "Status code is " + actual + " but expected " + expected
        );
        return this;
    }
    public void checkStatusCode(int actual, int expected) {
        message(
                actual == expected,
                "Correct Status Code (" + actual + ")",
                "Status code is " + actual + " but expected " + expected
        );
        Assert.assertEquals(actual, expected);
    }

    public void assertAll(Response response) {
        assertAll(
                "This is good response!\n" + Tag.inPre(response.asPrettyString(), CssInTag.Color.GREEN),
                "This response has problems!\n" + Tag.inPre(response.asPrettyString(), CssInTag.Color.RED)
        );
    }
}
