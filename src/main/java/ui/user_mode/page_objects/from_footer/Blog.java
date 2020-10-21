package ui.user_mode.page_objects.from_footer;

import org.openqa.selenium.By;
import ui.BasePageObject;
import ui.engine.OnixLocator;
import ui.engine.OnixWebDriver;
import ui.user_mode.general_parts.Footer;
import ui.user_mode.general_parts.MainHeader;

import java.util.ArrayList;
import java.util.List;

public class Blog extends BasePageObject implements Footer, MainHeader {
    public Blog(OnixWebDriver driver) {
        super(driver);
    }


    public OnixLocator POST = OnixLocator.makeOnixLocator(By.cssSelector(".post"));
    public OnixLocator LINK_IN_POST = OnixLocator.makeOnixLocator(By.cssSelector(".post div.post_descr a.title"));
    List<OnixLocator> elementsLocators = new ArrayList<>(List.of(
            POST, LINK_IN_POST
    ));


    public Blog clickRecentPosts() {
        driver.findElement(Locator.RECENT_POSTS).click();
        return this;
    }

    public Blog clickOnlineFitness() {
        driver.findElement(Locator.ONLINE_FITNESS).click();
        return this;
    }

    public Blog clickNews() {
        driver.findElement(Locator.NEWS).click();
        return this;
    }

    public Blog clickThinking() {
        driver.findElement(Locator.THINKING).click();
        return this;
    }

    public Blog clickFeedback() {
        driver.findElement(Locator.FEEDBACK).click();
        return this;
    }

    public int countPosts() {
        driver.scrollPageDown();
        int result =  driver.findElements(POST).size();
        driver.scrollPageUp();
        return result;
    }


    public enum Locator implements OnixLocator {
        RECENT_POSTS(By.xpath("//span[contains(text(), 'Recent posts')]")),
        ONLINE_FITNESS(By.xpath("//span[contains(text(), 'Online Fitness')]")),
        NEWS(By.xpath("//span[contains(text(), 'News')]")),
        TRAINING(By.xpath("//span[contains(text(), 'Training')]")),
        THINKING(By.xpath("//span[contains(text(), 'Thinking')]")),
        FEEDBACK(By.xpath("//span[contains(text(), 'Feedback')]")),

        ;
        private By path;

        Locator(By path) {
            this.path = path;
        }

        @Override
        public By getPath() {
            return path;
        }
    }
}
