package main_package.ui.engine;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.*;

public class OnixWebDriver {
    private WebDriver driver;
    private Map<String, Boolean> onixSettings;
    private Logger log;

    public OnixWebDriver(WebDriver driver) {
        log = LoggerFactory.getLogger(this.getClass());
        this.onixSettings = new HashMap<>();
        this.driver = driver;
        log.debug("new OnixWebDriver");
    }

    public void setSetting(String setting, Boolean status) {
        onixSettings.put(setting, status);
        log.debug("put " + setting + " setting to OnixWebDriver");
    }

    public boolean checkSetting(String setting) {
        if (onixSettings.containsKey(setting)) {
            log.trace("OnixWebDriver contains " + setting + " setting");
            return onixSettings.get(setting);
        }
        log.trace("OnixWebDriver haven't " + setting + " setting");
        return false;
    }

    public OnixWebElement findElement(OnixLocator locator) {
        By path = locator.getPath();
        OnixWebElement result = new OnixWebElement((driver.findElement(path)));
        log.trace("find webElement " + path);
        return result;
    }

    public OnixWebElement findElement(By seleniumPath) {
        OnixWebElement result = new OnixWebElement(driver.findElement(seleniumPath));
        log.trace("find webElement " + seleniumPath);
        return result;
    }

    public WebDriver getSeleniumDriver() {
        log.trace("return original seleniumDriver");
        return driver;
    }

    public List<OnixWebElement> findElements(OnixLocator locator) {
        log.trace("find all elements located by " + locator.getPath());
        List<OnixWebElement> result = new ArrayList<>();
        for (WebElement e : driver.findElements(locator.getPath())) {
            result.add(new OnixWebElement(e));
        }
        if(result.size() == 0) {
            log.warn("find 0 elements located by " + locator.getPath());
        }
        return result;
    }

    public List<OnixWebElement> findElements(By seleniumPath) {
        log.trace("find all elements located " + seleniumPath);
        List<OnixWebElement> result = new ArrayList<>();
        for (WebElement e : driver.findElements(seleniumPath)) {
            result.add(new OnixWebElement(e));
        }
        if(result.size() == 0) {
            log.warn("find 0 elements located " + seleniumPath);
        }
        return result;
    }

    public OnixWebElement waitVisibility(OnixLocator locator, int seconds) {
        log.trace("wait " + seconds + " seconds for visibility of element located by " + locator.getPath());
        return new OnixWebElement(new WebDriverWait(driver, Duration.ofSeconds(seconds))
                .until(ExpectedConditions.visibilityOfElementLocated(locator.getPath())));
    }

    public OnixWebElement waitVisibility(OnixLocator locator) {
        return waitVisibility(locator, 5);
    }

    public OnixWebElement waitVisibility(By seleniumPath, int seconds) {
        log.trace("wait " + seconds + " seconds for visibility of element located " + seleniumPath);
        return new OnixWebElement(new WebDriverWait(driver, Duration.ofSeconds(seconds))
                .until(ExpectedConditions.visibilityOfElementLocated(seleniumPath)));
    }

    public OnixWebElement waitVisibility(By seleniumPath) {
        return waitVisibility(seleniumPath, 5);
    }

    public OnixWebDriver toIframe(int index) {
        log.debug("switch to iframe[" + index + "]");
        return new OnixWebDriver(driver.switchTo().frame(index));
    }

    public OnixWebDriver toIframe(String nameOrId) {
        log.debug("switch to iframe with name/id = " + nameOrId);
        return new OnixWebDriver(driver.switchTo().frame(nameOrId));
    }

    public OnixWebDriver toIframe(OnixWebElement element) {
        log.debug("switch to iframe by " + element.getSeleniumWebElement().getTagName());
        return new OnixWebDriver(driver.switchTo().frame(element.getSeleniumWebElement()));
    }

    public OnixWebDriver toParentFrame() {
        log.trace("switch to parent frame");
        return new OnixWebDriver(driver.switchTo().parentFrame());
    }

    public void scrollPageDown() {
        waitVisibility(By.cssSelector("body"));
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");
        log.trace("scroll page down");
    }

    public void scrollPageUp() {
        waitVisibility(By.cssSelector("body"));
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, 0)");
        log.trace("scroll page up");
    }

    public void scrollTo(OnixLocator locator) {
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", findElement(locator).getSeleniumWebElement());
        log.trace("scroll page to element located by" + locator.getPath());
    }

    public void scrollTo(By seleniumPath) {
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", findElement(seleniumPath).getSeleniumWebElement());
        log.trace("scroll page to element located " + seleniumPath);
    }

    public void scrollTo(OnixWebElement element) {
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", element.getSeleniumWebElement());
        log.trace("scroll page to element " + element.getSeleniumWebElement().getTagName());
    }

    public void scrollTo(WebElement element) {
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", element);
        log.trace("scroll page to element " + element.getTagName());
    }

    public void protectedScrollTo(OnixLocator locator, int wait) {
        scrollTo(waitVisibility(locator, wait));
        log.trace("scroll to element located by " + locator.getPath() + " after waiting for visibility");
    }

    public void protectedScrollTo(By seleniumPath, int wait) {
        scrollTo(waitVisibility(seleniumPath, wait));
        log.trace("scroll to element located " + seleniumPath + " after waiting for visibility");
    }

    public void protectedScrollTo(OnixLocator locator) {
        scrollTo(waitVisibility(locator));
        log.trace("scroll to element located by " + locator.getPath() + " after waiting for visibility");
    }

    public void protectedScrollTo(By seleniumPath) {
        scrollTo(seleniumPath);
        log.trace("scroll to element located " + seleniumPath + " after waiting for visibility");
    }

    public void get(String url) {
        driver.get(url);
        log.debug("navigate driver to " + url);
    }

    public void quit() {
        driver.quit();
        log.debug("quit driver");
    }

    public boolean isElementPresent(OnixLocator locator) {
        log.trace("check is element located by " + locator.getPath() + " present");
        return findElements(locator).size() > 0;
    }

    public boolean isElementPresent(By path) {
        log.trace("check is element located by '{}' present", path);
        return findElements(path).size() > 0;
    }

    public boolean waitInvisibilityOf(OnixLocator locator) {
        log.trace("wait for invisibility of element located by " + locator.getPath());
        return new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.invisibilityOfElementLocated(locator.getPath()));
    }

    public boolean waitInvisibilityOf(OnixWebElement element) {
        log.trace("wait for invisibility of " + element);
        return new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.invisibilityOf(element.getSeleniumWebElement()));
    }

    public OnixWebElement waitToClick(OnixLocator locator) {
        log.trace("wait to click the element located by " + locator.getPath());
        WebElement e = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(locator.getPath()));
        return new OnixWebElement(e);
    }

    HashMap<String, String> tabs;

    public OnixWebDriver registerCurrentTab(String name) {
        if (tabs == null) {
            tabs = new HashMap<>();
        }
        tabs.put(name, driver.getWindowHandle());
        log.debug("register current tab by " + name);
        return this;
    }
    public OnixWebDriver switchToRegisterTab(String name) {
        driver.switchTo().window(tabs.get(name));
        log.debug("switch to tab with " + name);
        return this;
    }
    public OnixWebDriver closeTabsExceptCurrent() {
        String current = driver.getWindowHandle();
        for(String s : driver.getWindowHandles()) {
            driver.switchTo().window(s);
            if(!s.equals(current)) {
                driver.close();
            }
        }
        driver.switchTo().window(current);
        tabs = null;
        log.debug("close all tabs except current");
        return this;
    }
    public OnixWebDriver registerTabWithUrlLike(String urlsPart, String nameForTabs) {
        String current = driver.getWindowHandle();
        for(String s : driver.getWindowHandles()) {
            if(driver.switchTo().window(s).getCurrentUrl().contains(urlsPart)) {
                if(tabs == null) {
                    tabs = new HashMap<>();
                }
                tabs.put(nameForTabs, s);
                break;
            }
        }
        driver.switchTo().window(current);
        log.debug("register tab that contains '" + urlsPart + "' in url by name '" + nameForTabs + "'");
        return this;
    }

    public String getUrl() {
        log.trace("return current url");
        return driver.getCurrentUrl();
    }

    public OnixWebDriver hoverToElementLocated(By path) {
        Actions actions = new Actions(driver);
        actions.moveToElement(this.waitVisibility(path).getSeleniumWebElement());
        log.trace("hover to element located " + path);
        return this;
    }
    public OnixWebDriver hoverToElementLocated(OnixLocator locator) {
        return hoverToElementLocated(locator.getPath());
    }

    public OnixWebDriver switchAnotherTab(String nameForOldTab) {
        this.registerCurrentTab(nameForOldTab);
        for(String s : driver.getWindowHandles()) {
            if(!s.equals(tabs.get(nameForOldTab))) {
                driver.switchTo().window(s);
            }
        }
        log.debug("switch to another tab");
        return this;
    }

    public OnixWebDriver back() {
        driver.navigate().back();
        log.debug("driver navigate back");
        return this;
    }

    public OnixWebDriver executeJsScript(String script) {
        ((JavascriptExecutor) driver).executeScript(script);
        log.debug("execute JS script: \n" + script);
        return this;
    }

    public void alertAccept() {
        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.alertIsPresent());
        alert.accept();
        log.debug("accept alert");
    }



}
