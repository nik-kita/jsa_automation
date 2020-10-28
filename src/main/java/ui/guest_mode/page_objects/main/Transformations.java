package ui.guest_mode.page_objects.main;


import org.openqa.selenium.By;
import ui.BasePageObject;
import ui.engine.OnixLocator;
import ui.engine.OnixWebDriver;
import ui.guest_mode.general_parts.Footer;
import ui.guest_mode.general_parts.MainHeader;

public class Transformations extends BasePageObject implements Footer, MainHeader {
    public Transformations(OnixWebDriver driver) {
        super(driver);
    }

    public OnixLocator TRANSFORMATION_BLOCK = OnixLocator
            .makeOnixLocator(By
                    .xpath("//div[@class='masonry-grid']//div[contains(@class, 'masonry-block')][contains(@style, 'display: block')]"));

    public Transformations clickSeeMoreButton() {
        driver.scrollPageDown();
        driver.findElement(Locator.SEE_MORE_BUTTON).click();
        return new Transformations(driver);
    }

    public int countTransformations() {
        return driver.findElements(TRANSFORMATION_BLOCK).size();
    }

    public boolean isSeeMoreButtonPresent() {
        return driver
                .findElement(Locator.SEE_MORE_BUTTON)
                .getSeleniumWebElement().isDisplayed();
    }
    public boolean seeMore() {
        if(isSeeMoreButtonPresent()) {
            clickSeeMoreButton();
            return true;
        }
        return false;
    }

    public enum Locator implements OnixLocator {
        SEE_MORE_BUTTON(By.cssSelector(".transformation_wr a")),
        HIDDEN_SEE_MORE_BUTTON(By.xpath("//*[@class='transformation_wr']//a[@style='display: none;']"))

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
