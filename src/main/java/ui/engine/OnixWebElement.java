package ui.engine;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OnixWebElement {
    private WebElement element;
    private Logger log;

    public OnixWebElement(WebElement element) {
        log = LoggerFactory.getLogger(this.getClass());
        this.element = element;
        log.trace("new OnixWebElement " + this);
    }

    public WebElement getSeleniumWebElement() {
        log.trace("get WebElement " + this + " from OnixWebElement");
        return element;
    }

    public void click() {
        element.click();
        log.debug("Click: " + this);
    }

    public void sendKeys(CharSequence keysToSend) {
        element.sendKeys(keysToSend);
        log.trace("sendKeys '" + keysToSend + "' to " + this);
    }

    public String text() {
        log.trace("read text from " + this);
        return element.getText();
    }

    public OnixWebElement findElementInsideThis(OnixLocator locator) {
        log.trace("find in " + this + " new element by " + locator.getPath());
        return new OnixWebElement(element.findElement(locator.getPath()));
    }
    public OnixWebElement findElementInsideThis(By path) {
        log.trace("find in " + this + " new element by " + path);
        return new OnixWebElement(element.findElement(path));
    }

    @Override
    public String toString() {
        String toString = element.toString().substring(element.toString().indexOf(")] -> ") + 6);
        return toString;
    }
}
