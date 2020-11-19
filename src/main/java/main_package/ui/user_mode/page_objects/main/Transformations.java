package main_package.ui.user_mode.page_objects.main;


import org.openqa.selenium.By;
import main_package.ui.BasePageObject;
import main_package.ui.engine.OnixLocator;
import main_package.ui.engine.OnixWebDriver;
import main_package.ui.user_mode.general_parts.Footer;
import main_package.ui.user_mode.general_parts.MainHeader;

public class Transformations extends BasePageObject implements Footer, MainHeader {

    public Transformations(OnixWebDriver driver) {
        super(driver);
    }

    public OnixLocator TRANSFORMATION_BLOCK = makeOnixLocator(By
                    .xpath("//div[@class='masonry-grid']//div[contains(@class, 'masonry-block')][contains(@style, 'display: block')]"), this.getClass());
    public OnixLocator HIDDEN_SEE_MORE_BUTTON = makeOnixLocator(By.xpath("//*[@class='transformation_wr']//a[@style='display: none;']"), this.getClass());

    public Transformations clickSeeMoreButton() {
        driver.scrollPageDown();
        driver.findElement(Locator.SEE_MORE_BUTTON).click();
        return new Transformations(driver);
    }

    public int countTransformations() {
        logger.debug("count posts");
        return driver.findElements(TRANSFORMATION_BLOCK).size();
    }

    public boolean isSeeMoreButtonPresent() {
        boolean result = driver
                .findElement(Locator.SEE_MORE_BUTTON)
                .getSeleniumWebElement().isDisplayed();
        logger.trace("the 'see more button' is present = " + result);
        return result;
    }

    public enum Locator implements OnixLocator {
        SEE_MORE_BUTTON(By.cssSelector(".transformation_wr a")),


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