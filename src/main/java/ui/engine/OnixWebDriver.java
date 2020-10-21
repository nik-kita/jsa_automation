package ui.engine;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;

public class OnixWebDriver {
    private WebDriver driver;
    private Map<String, Boolean> onixSettings;

    public OnixWebDriver(WebDriver driver) {
        this.onixSettings = new HashMap<>();
        this.driver = driver;
    }

    public void setSetting(String setting, Boolean status) {
        onixSettings.put(setting, status);
    }

    public boolean checkSetting(String setting) {
        if (onixSettings.containsKey(setting)) {
            return onixSettings.get(setting);
        }
        return false;
    }

    public OnixWebElement findElement(OnixLocator locator) {
        return new OnixWebElement((driver.findElement(locator.getPath())));
    }

    public OnixWebElement findElement(By seleniumPath) {
        return new OnixWebElement(driver.findElement(seleniumPath));
    }

    public WebDriver getSeleniumDriver() {
        return driver;
    }

    public List<OnixWebElement> findElements(OnixLocator locator) {
        List<OnixWebElement> result = new ArrayList<>();
        for (WebElement e : driver.findElements(locator.getPath())) {
            result.add(new OnixWebElement(e));
        }
        return result;
    }

    public List<OnixWebElement> findElements(By seleniumPath) {
        List<OnixWebElement> result = new ArrayList<>();
        for (WebElement e : driver.findElements(seleniumPath)) {
            result.add(new OnixWebElement(e));
        }
        return result;
    }

    public OnixWebElement waitVisibility(OnixLocator locator, int seconds) {
        return new OnixWebElement(new WebDriverWait(driver, Duration.ofSeconds(seconds))
                .until(ExpectedConditions.visibilityOfElementLocated(locator.getPath())));
    }

    public OnixWebElement waitVisibility(OnixLocator locator) {
        return waitVisibility(locator, 5);
    }

    public OnixWebElement waitVisibility(By seleniumPath, int seconds) {
        return new OnixWebElement(new WebDriverWait(driver, Duration.ofSeconds(seconds))
                .until(ExpectedConditions.visibilityOfElementLocated(seleniumPath)));
    }

    public OnixWebElement waitVisibility(By seleniumPath) {
        return waitVisibility(seleniumPath, 5);
    }

    public OnixWebDriver toIframe(int index) {
        return new OnixWebDriver(driver.switchTo().frame(index));
    }

    public OnixWebDriver toIframe(String nameOrId) {
        return new OnixWebDriver(driver.switchTo().frame(nameOrId));
    }

    public OnixWebDriver toIframe(OnixWebElement element) {
        return new OnixWebDriver(driver.switchTo().frame(element.getSeleniumWebElement()));
    }

    public OnixWebDriver toParentFrame() {
        return new OnixWebDriver(driver.switchTo().parentFrame());
    }

    public void scrollPageDown() {
        waitVisibility(By.cssSelector("body"));
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void scrollPageUp() {
        waitVisibility(By.cssSelector("body"));
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, 0)");
    }

    public void scrollTo(OnixLocator locator) {
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", findElement(locator).getSeleniumWebElement());
    }

    public void scrollTo(By seleniumPath) {
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", findElement(seleniumPath).getSeleniumWebElement());
    }

    public void scrollTo(OnixWebElement element) {
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", element.getSeleniumWebElement());
    }

    public void scrollTo(WebElement element) {
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void protectedScrollTo(OnixLocator locator, int wait) {
        scrollTo(waitVisibility(locator, wait));
    }

    public void protectedScrollTo(By seleniumPath, int wait) {
        scrollTo(waitVisibility(seleniumPath, wait));
    }

    public void protectedScrollTo(OnixLocator locator) {
        scrollTo(waitVisibility(locator));
    }

    public void protectedScrollTo(By seleniumPath) {
        scrollTo(seleniumPath);
    }

    public void get(String url) {
        driver.get(url);
    }

    public void quit() {
        driver.quit();
    }

    public boolean isElementPresent(OnixLocator locator) {
        return findElements(locator).size() > 0;
    }

    public boolean waitInvisibilityOf(OnixLocator locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.invisibilityOfElementLocated(locator.getPath()));
    }

    public OnixWebElement waitToClick(OnixLocator locator) {
        WebElement e = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(locator.getPath()));
        return new OnixWebElement(e);
    }

    public OnixWebDriver tabWhereTitleContains(String name) {
        Set<String> tabs = driver.getWindowHandles();
        for (String s : tabs) {
            if (s.contains(name)) {
                break;
            }
        }
        return this;
    }

    HashMap<String, String> tabs;

    public OnixWebDriver registerCurrentTab(String name) {
        if (tabs == null) {
            tabs = new HashMap<>();
        }
        tabs.put(name, driver.getWindowHandle());
        return this;
    }
    public OnixWebDriver switchToRegisterTab(String name) {
        driver.switchTo().window(tabs.get(name));
        return this;
    }
    public OnixWebDriver closeTabsExceptCurrent() {
        String current = driver.getWindowHandle();
        for(String s : driver.getWindowHandles()) {
            if(!s.equals(current)) {
                driver.close();
            }
        }
        driver.switchTo().window(current);
        tabs = null;
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
        return this;
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public OnixWebDriver hoverToElementLocated(By path) {
        Actions actions = new Actions(driver);
        actions.moveToElement(this.waitVisibility(path).getSeleniumWebElement());
        return this;
    }
    public OnixWebDriver hoverToElementLocated(OnixLocator locator) {
        return hoverToElementLocated(locator.getPath());
    }

}
