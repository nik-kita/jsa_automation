package ui;


import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import ui.engine.OnixWebDriver;
import ui.guest_mode.page_objects.main.Main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class OnixTestRunner {
    public OnixAssert onixAssert;
    public OnixWebDriver driver;
    private Main mainPO;
    String baseUrl = "https://www.jamessmithacademy.com/";

    public OnixWebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    public void settingDriver() {
        WebDriverManager.chromedriver().setup();
        Map<String, Object> prefs = new HashMap<>();
        // Set the notification setting it will override the default setting
        prefs.put("profile.default_content_setting_values.notifications", 2);
        ChromeOptions options = new ChromeOptions();
        //--------
        options.addArguments("--start-maximized");
        options.addArguments("--disable-web-security");
        options.addArguments("--no-proxy-server");
        options.setExperimentalOption("prefs", prefs);
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        //--------
        //chrome notification about automation will not displayed
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("prefs", prefs);
        // pass the options object in Chrome driver
        WebDriver chrome = new ChromeDriver(options);
        chrome.manage().window().maximize();
        chrome.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver = new OnixWebDriver(chrome);
        onixAssert = new OnixAssert(driver);
    }

    @AfterClass
    public void driverOff() {
        driver.quit();
    }

    protected Main openSite() {
        driver.get(baseUrl);
        mainPO = new Main(driver);
        return mainPO;
    }

    public Object[] mergeArrays(Object[]... arrays) {
        int length = 0;
        for (Object[] array : arrays) {
            length += array.length;
        }
        Object[] result = new Object[length];
        int pos = 0;
        for (Object[] array : arrays) {
            for (Object e : array) {
                result[pos] = e;
                pos++;
            }
        }
        return result;
    }


    public void allureAddMarkdownDescriptionFromFile(String fileName) {
        String html = null;
        try {
            html = HtmlRenderer
                    .builder()
                    .build()
                    .render(Parser
                            .builder()
                            .build()
                            .parse(Files
                                    .readString(Path.of("src/test/resources/tests/" + fileName), StandardCharsets.UTF_8)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Allure.descriptionHtml(html);
    }
    public void allureAddTxtFileAttachment(String fileName) {
        try {
            Allure.addAttachment(fileName, new FileInputStream("src/test/resources/tests/" + fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
