package ui;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import ui.engine.OnixLocator;
import ui.engine.OnixWebDriver;

public class OnixAssert {
    OnixWebDriver driver;
    SoftAssert softAssert;
    Logger logger;

    public void assertAll() {
        softAssert.assertAll();
        softAssert = null;
    }

    public OnixAssert(OnixWebDriver driver) {
        logger = LoggerFactory.getLogger(this.getClass());
        this.driver = driver;
    }

    public void checkFirstGreaterSecond(int first, int second) {
        String errorMessage = "\n\n" +
                "\n----------------------------" +
                "\nIn " + getClass()/*.getClassLoader()*/.getName() +
                "\n----------------------------" +
                "\n=== FIRST IS NOT GREATER THAN SECOND ===\n" +
                "\nFirst is:  " + first +
                "\nSecond is: " + second;
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
        softAssert.assertEquals(actual, expected, errorMessage);
        return softAssert;
    }

    public void checkCountOfElementByLocator(OnixLocator locator, int expectedElCount) {
        int actualElCount = driver
                .findElements(locator)
                .size();

        String errorMessage = "\n\n" +
                "\n----------------------------" +
                "\nIn " + locator.getClass().getName() +
                "\n\n" + locator.name() +
                "\n" + locator.getPath() +
                "\n----------------------------" +
                "\n=== NUMBER OF ELEMENTS ===\n";
        Assert.assertEquals(actualElCount, expectedElCount, errorMessage);
    }

    public SoftAssert softCheckCountOfElementByLocator(OnixLocator locator, int expectedElCount) {
        if(softAssert == null) {
            softAssert = new SoftAssert();
        }
        int actualElCount = driver
                .findElements(locator)
                .size();
        String errorMessage = "\n\n" +
                "\n----------------------------" +
                "\nIn " + locator.getClass().getName() +
                "\n\n" + locator.name() +
                "\n" + locator.getPath() +
                "\n----------------------------" +
                "\n=== NUMBER OF ELEMENTS ===\n";
        softAssert.assertEquals(actualElCount, expectedElCount, errorMessage);
        return softAssert;
    }
    public void checkUrlContains(String wordInUrl) {
        String url = driver.getUrl();
        Assert.assertTrue(url.toLowerCase().contains(wordInUrl.toLowerCase()));
    }
    public void softCheckUrlContains(String wordInUrl) {
        if(softAssert == null) {
            softAssert = new SoftAssert();
        }
        String url = driver.getUrl();
        softAssert.assertTrue(url.toLowerCase().contains(wordInUrl.toLowerCase()));
    }
}
