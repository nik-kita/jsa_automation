package main_package.engine.test_engine;


import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import main_package.engine.OnixLocator;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.testng.*;
import org.testng.annotations.*;
import main_package.engine.OnixWebDriver;
import main_package.ui.guest_mode.page_objects.main.Main;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;


public class OnixUiTestRunner extends OnixTestRunner {
    public OnixUiAssert onixUiAssert;
    public OnixWebDriver driver;
    private Main mainPO;
    String baseUrl = "https://www.jamessmithacademy.com/";
    public Logger log;

    public OnixWebDriver getDriver() {
        return driver;
    }

    @BeforeSuite
    public void beforeSuite(ITestContext context) {
        MDC.put("run", String.valueOf(new Timestamp(System.currentTimeMillis())));
        ISuite suite = context.getSuite();
        String suiteName = suite.getName();
        MDC.put("suite", suiteName);
        Logger suiteLogger = LoggerFactory.getLogger(this.getClass());
        suiteLogger.debug("Suite '{}' is started.", suiteName);
    }

    @BeforeClass
    public void settingDriver() {
        String className = this.getClass().toString();
        MDC.put("class", className);
        log = LoggerFactory.getLogger(this.getClass());
        log.debug("Class '{}' is started.", className);
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
//        chrome.manage().window().maximize();
        chrome.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        driver = new OnixWebDriver(chrome);
        onixUiAssert = new OnixUiAssert(driver);
    }

    @BeforeMethod
    public void BeforeMethod(Method method) {
        String name = method.getName();
        MDC.put("test", name);
        log.info("Test '{}' is started", name);
    }

    @AfterMethod
    public void cleanLoggerFromTestInfo(ITestResult result) {
        MDC.put("sms_role", "test");
        String name = result.getMethod().getMethodName();
        Long executionTime = result.getEndMillis() - result.getStartMillis();
        if(result.isSuccess()) {
            MDC.put("test_result", "success");
            log.info("Test '{}' is successfully finished. Time: {} ms.", name, executionTime);
        } else {
            MDC.put("test_result", "fail");
            log.warn("Test '{}' fails! ({} ms)", name, executionTime);
        }
        MDC.remove("sms_role");
        MDC.remove("test");
    }

    @AfterClass
    public void driverOff(ITestContext context) {
        driver.quit();
        log.debug("Class '{}' is finished.", this.getClass().toString());
        MDC.remove("class");
        MDC.remove("test");
    }

    @AfterSuite
    public void afterSuite(ITestContext context) {
        ISuite suite = context.getSuite();
        List<ITestNGMethod> allMethods = suite.getAllMethods();
        List<IInvokedMethod> allInvokedMethods = suite.getAllInvokedMethods();
        Integer ignoreTests = allMethods.size() - allInvokedMethods.size();
        if(!suite.getSuiteState().isFailed()) {
            log.debug("Suite '{}' is finished successfully!", suite.getName());
        } else {
            log.warn("Suite '{}' is fail!", suite.getName());
        }
        MDC.remove("suite");
        MDC.remove("class");
        MDC.remove("test");
    }

    protected Main openSite() {
        driver.get(baseUrl);
        mainPO = new Main(driver);
        log.debug("Open https://www.jamessmithacademy.com/");
        return mainPO;
    }
    protected Main openSite(OnixUiAssert onixUiAssert) {
        driver.get(baseUrl);
        log.debug("Open https://www.jamessmithacademy.com/");
        mainPO = new Main(driver);
        for(OnixLocator l : Main.Locator.values()) {
            onixUiAssert.softCheckCountOfElementByLocator(l, 1);
        }
        return mainPO;
    }





    public void allureAddMarkdownDescription(String markdown) {
        String html = HtmlRenderer
                .builder()
                .build()
                .render(Parser
                        .builder()
                        .build()
                        .parse(markdown));
        Allure.descriptionHtml(html);
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
