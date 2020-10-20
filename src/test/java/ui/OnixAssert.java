package ui;


import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import ui.engine.OnixLocator;
import ui.engine.OnixWebDriver;

public class OnixAssert {
    OnixWebDriver driver;

    public OnixAssert(OnixWebDriver driver) {
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

    public SoftAssert softCheckFirstGreaterSecond(int first, int second, SoftAssert softAssert) {
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

    public SoftAssert softCheckCount(int actual, int expected, SoftAssert softAssert) {
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

    public SoftAssert softCheckCountOfElementByLocator(OnixLocator locator, int expectedElCount, SoftAssert softAssert) {
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
}
