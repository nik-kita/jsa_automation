package main_package.ui.___U_S_E_R___.page_objects.home_header.learn;

import main_package.engine.test_engine.FlyTester;
import org.openqa.selenium.By;
import main_package.ui.BasePageObject;
import main_package.engine.OnixLocator;
import main_package.engine.OnixWebDriver;
import main_package.ui.___U_S_E_R___.general_parts.home.HomePart;

public class Learn extends BasePageObject implements HomePart {

    public Learn(OnixWebDriver driver) {
        super(driver);
    }
    @Override
    public Learn test(FlyTester flyTester) {
        flyTester.test();
        return this;
    }

    public SearchVideos clickSearchIcon() {
        driver.findElement(Locator.SEARCH_ICON).click();
        logger.debug("'SearchVideos' from 'Learn'");
        return new SearchVideos(driver);
    }

    public CategoriesMultiPage clickCategory() {
        driver.findElement(Locator.CATEGORY_INTRODUCING).click();
        return new CategoriesMultiPage(driver);
    }

    public Favourites clickFavourites() {
        driver.findElement(Locator.FAVOURITES).click();
        return new Favourites(driver);
    }

    public ToComplete clickToComplete() {
        driver.findElement(Locator.TO_COMPLETE).click();
        return new ToComplete(driver);
    }
    public SingleLearnVideo clickVideo() {
        driver.findElement(Locators.VIDEO_ITEM).click();
        return new SingleLearnVideo(driver);
    }



    public enum Locator implements OnixLocator {
        SEARCH_ICON(By.cssSelector(".navbar-nav [href='#/learn/search']")),
        CATEGORY_INTRODUCING(By.cssSelector("[href=\"#/learn/category/14/Introducing\"]")),
        CATEGORY_EX_PRINCIPLES(By.cssSelector("[href=\"#/learn/category/15/Exercise Principles\"]")),
        CATEGORY_NUTRITION_PRINCIPLES(By.cssSelector("[href=\"#/learn/category/16/Nutrition Principles\"]")),
        CATEGORY_EXERCISES(By.cssSelector("[href=\"#/learn/category/26/Exercises\"]")),
        CATEGORY_MOBILITY_FUNCTIONS(By.cssSelector("[href=\"#/learn/category/19/Mobility & Functions\"]")),
        CATEGORY_SOCIAL_MEDIA(By.cssSelector("[href=\"#/learn/category/21/Social Media\"]")),
        FAVOURITES(By.cssSelector("[href=\"#/learn/favourite\"]")),
        TO_COMPLETE(By.cssSelector("[href=\"#/learn/uncompleted\"]")),

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
    public enum Locators implements OnixLocator {
        VIDEO_ITEM(By.cssSelector(".horizontal_video_list_item_image")),

        ;
        private By path;

        Locators(By path) {
            this.path = path;
        }

        @Override
        public By getPath() {
            return path;
        }
    }
}
