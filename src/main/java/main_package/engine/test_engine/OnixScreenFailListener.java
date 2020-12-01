package main_package.engine.test_engine;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class OnixScreenFailListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println(result.getTestContext().getName());

        Object i = result.getInstance();

        saveScreenshotPNG(((OnixTestRunner) i).driver.getSeleniumDriver());
    }
    @Override
    public void onTestSkipped(ITestResult result) {

    }

    private void takeScreenShort(ITestResult result) {

    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
