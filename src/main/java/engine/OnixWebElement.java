package engine;

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
}
