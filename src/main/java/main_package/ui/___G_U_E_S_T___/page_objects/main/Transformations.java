package main_package.ui.___G_U_E_S_T___.page_objects.main;


import main_package.engine.test_engine.FlyTester;
import main_package.engine.test_engine.OnixUiAssert;
import org.openqa.selenium.By;
import main_package.ui.BasePageObject;
import main_package.engine.OnixLocator;
import main_package.engine.OnixWebDriver;
import main_package.ui.___G_U_E_S_T___.general_parts.Footer;
import main_package.ui.___G_U_E_S_T___.general_parts.MainHeader;

public class Transformations extends BasePageObject implements Footer, MainHeader {
    public Transformations(OnixWebDriver driver) {
        super(driver);
        logger.debug("'Transformations' page is open.");
    }
    public Transformations check(OnixUiAssert onixUiAssert) {
        for(OnixLocator l : OnixUiAssert.mergeArrays(
                Transformations.Locator.values(),
                MainHeader.HeaderLocator.values(),
                Footer.FooterLocator.values()
        )) {
            onixUiAssert.softCheckCountOfElementByLocator(l, 1);
        }
        return this;
    }
    @Override
    public Transformations test(FlyTester flyTester) {
        flyTester.test();
        return this;
    }
    public OnixLocator TRANSFORMATION_BLOCK = makeOnixLocator(By
                    .xpath("//div[@class='masonry-grid']//div[contains(@class, 'masonry-block')][contains(@style, 'display: block')]"), this.getClass());

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
        return driver
                .findElement(Locator.SEE_MORE_BUTTON)
                .getSeleniumWebElement().isDisplayed();
    }
    public boolean seeMore() {
        if(isSeeMoreButtonPresent()) {
            clickSeeMoreButton();
            return true;
        }
        logger.debug("all posts are shown so 'see more' button is not exists");
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
