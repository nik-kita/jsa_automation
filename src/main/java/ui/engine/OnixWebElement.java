package ui.engine;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class OnixWebElement {
    private WebElement element;

    public OnixWebElement(WebElement element) {
        this.element = element;
    }

    public WebElement getSeleniumWebElement() {
        return element;
    }

    public void click() {
        element.click();
    }

    public void sendKeys(CharSequence keysToSend) {
        element.sendKeys(keysToSend);
    }

    public String text() {
        return element.getText();
    }

    public OnixWebElement findElementInsideThis(OnixLocator locator) {
        return new OnixWebElement(element.findElement(locator.getPath()));
    }
    public OnixWebElement findElementInsideThis(By path) {
        return new OnixWebElement(element.findElement(path));
    }
}
