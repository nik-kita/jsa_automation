package test_engine;


import jdk.jfr.StackTrace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import ui.engine.OnixLocator;
import ui.engine.OnixWebDriver;

public class OnixAssert {
    OnixWebDriver driver;
    SoftAssert softAssert;
    int softTotalCounter;
    int softSuccessCounter;
    Logger logger;

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

    public OnixAssert(OnixWebDriver driver) {
        logger = LoggerFactory.getLogger(this.getClass());
        this.driver = driver;
        softTotalCounter = softSuccessCounter = 0;
    }

    public void checkFirstGreaterSecond(int first, int second) {
        String errorMessage = "\n\n" +
                "\n----------------------------" +
                "\nIn " + getClass()/*.getClassLoader()*/.getName() +
                "\n----------------------------" +
                "\n=== FIRST IS NOT GREATER THAN SECOND ===\n" +
                "\nFirst is:  " + first +
                "\nSecond is: " + second;
                if(first < second) {
                    StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[2];
                    String getclassloadername = stackTraceElement.getClassLoaderName();
                    String className = stackTraceElement.getClassName();
                    String methodName = stackTraceElement.getMethodName();
                    logger.error("Assertion fail classloader " + getclassloadername + ", classname " + className + ", mehodname " + methodName + "\n" + stackTraceElement);
                }
        boolean result = first > second;
        message(result,
                first + " > " + second,
                "(" + first + " > " + second + ") != true");
        Assert.assertTrue(first > second, errorMessage);
    }

    public SoftAssert softCheckFirstGreaterSecond(int first, int second) {
        if(softAssert == null) {
            softAssert = new SoftAssert();
        }
        String errorMessage = "\n\n" +
                "\n----------------------------" +
                "\nIn " + getClass().getClassLoader().getName() +
                "\n----------------------------" +
                "\n=== FIRST IS NOT GREATER THAN SECOND ===\n" +
                "\nFirst is:  " + first +
                "\nSecond is: " + second + "\n\n";
        softAssert.assertTrue(first > second, errorMessage);
        boolean result = first > second;
        softMessage(result,
                first + " > " + second,
                "(" + first + " > " + second + ") != true");
        return softAssert;
    }

    public void checkCount(int actual, int expected) {
        String errorMessage = "\n\n" +
                "\n----------------------------" +
                "\nIn " + getClass().getClassLoader().getName() +
                "\n----------------------------" +
                "\n=== AMOUNT ===\n" +
                "\nActual:   " + actual +
                "\nExpected: " + expected;
        boolean result = actual == expected;
        message(result,
                "Counting result is " + actual,
                "Counting result is " + actual + ". However expected " + expected);
        Assert.assertEquals(actual, expected, errorMessage);
    }

    public SoftAssert softCheckCount(int actual, int expected) {
        if(softAssert == null) {
            softAssert = new SoftAssert();
        }
        String errorMessage = "\n\n" +
                "\n----------------------------" +
                "\nIn " + getClass().getClassLoader().getName() +
                "\n----------------------------" +
                "\n=== AMOUNT ===\n" +
                "\nActual:   " + actual +
                "\nExpected: " + expected;
        boolean result = actual == expected;
        softMessage(result,
                "Counting result is " + actual,
                "Counting result is " + actual + ". However expected " + expected);
        softAssert.assertEquals(actual, expected, errorMessage);
        return softAssert;
    }

    public void checkCountOfElementByLocator(OnixLocator locator, int expectedElCount) {
        int actualElCount = driver
                .findElements(locator)
                .size();
        String locatorName = locator.name();
        String locatorPath = locator.getPath().toString();
        String locatorClass = locator.getClass().getName();

        String errorMessage = "\n" +
                "\n----------------------------" +
                "\nIn " + locatorClass +
                "\n\n" + locatorName +
                "\n" + locatorPath +
                "\n----------------------------" +
                "\n=== NUMBER OF ELEMENTS ===\n";
        boolean result = actualElCount == expectedElCount;
        message(result,
                locatorClass + "." + locatorName + "(" + locatorPath + ") find " + actualElCount + " elements.",
                locatorClass + "." + locatorName + "(" + locatorPath + ") find " + actualElCount + " elements instead of " + expectedElCount);
        Assert.assertEquals(actualElCount, expectedElCount, errorMessage);
    }

    public SoftAssert softCheckCountOfElementByLocator(OnixLocator locator, int expectedElCount) {
        if(softAssert == null) {
            softAssert = new SoftAssert();
        }
        int actualElCount = driver
                .findElements(locator)
                .size();
        String locatorName = locator.name();
        String locatorPath = locator.getPath().toString();
        String locatorClass = locator.getClass().getName();

        String errorMessage = "\n" +
                "\n----------------------------" +
                "\nIn " + locatorClass +
                "\n\n" + locatorName +
                "\n" + locatorPath +
                "\n----------------------------" +
                "\n=== NUMBER OF ELEMENTS ===\n";
        boolean result = actualElCount == expectedElCount;
        softMessage(result,
                locatorClass + "." + locatorName + "(" + locatorPath + ") find " + actualElCount + " elements.",
                locatorClass + "." + locatorName + "(" + locatorPath + ") find " + actualElCount + " elements instead of " + expectedElCount);
        softAssert.assertEquals(actualElCount, expectedElCount, errorMessage);
        return softAssert;
    }
    public void checkUrlContains(String wordInUrl) {
        String url = driver.getUrl();
        boolean result = url.toLowerCase().contains(wordInUrl.toLowerCase());
        message(result, "Current url '" + url + "' contains '" + wordInUrl + "'", "Current url is '" + url + "' however you try to find '" + wordInUrl + "' in it.");
        Assert.assertTrue(url.toLowerCase().contains(wordInUrl.toLowerCase()));
    }
    public void softCheckUrlContains(String wordInUrl) {
        if(softAssert == null) {
            softAssert = new SoftAssert();
        }
        String url = driver.getUrl();
        boolean result = url.toLowerCase().contains(wordInUrl.toLowerCase());
        softMessage(result, "Current url '" + url + "' contains '" + wordInUrl + "'", "Current url is '" + url + "' however you try to find '" + wordInUrl + "' in it.");
        softAssert.assertTrue(result);
    }
    public void message(boolean success, String good, String bad) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
        String fromClass = stackTraceElement.getClassName();
        String fromMethod = stackTraceElement.getMethodName();
        if(success) {
            logger.info("Success! " + good + " From " + fromClass + "." + fromMethod + "() ");
        } else {
            logger.error("Fail!!! " + bad + " From " + fromClass + "." + fromMethod + "() ");
        }
    }
    public void softMessage(boolean success, String good, String bad) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
        String fromClass = stackTraceElement.getClassName();
        String fromMethod = stackTraceElement.getMethodName();
        if(success) {
            logger.debug("Pass in softAssert: " + good + " From " + fromClass + "." + fromMethod + "() line ");
            softSuccessCounter++;
            softTotalCounter++;
        } else {
            logger.warn("Fail in softAssert: " + bad + " From " + fromClass + "." + fromMethod + "() ");
            softTotalCounter++;
        }
    }
}