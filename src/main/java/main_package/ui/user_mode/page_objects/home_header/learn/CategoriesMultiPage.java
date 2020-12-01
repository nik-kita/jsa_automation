package main_package.ui.user_mode.page_objects.home_header.learn;

import main_package.ui.BasePageObject;
import main_package.engine.test_engine.FlyTester;
import main_package.engine.OnixLocator;
import main_package.engine.OnixWebDriver;
import main_package.ui.user_mode.general_parts.home.HomeHeaderPart;
import org.openqa.selenium.By;

public class CategoriesMultiPage extends BasePageObject implements HomeHeaderPart {
    public CategoriesMultiPage(OnixWebDriver driver) {
        super(driver);
    }
    @Override
    public CategoriesMultiPage test(FlyTester flyTester) {
        flyTester.test();
        return this;
    }

    public Learn clickBackArrow() {
        driver.findElement(Locator.BACK_ARROW).click();
        return new Learn(driver);
    }

    public enum CategoriesVariant {
        INTRODUCING, EXERCISE_PRINCIPLES, NUTRITION_PRINCIPLES, EXERCISES, MOBILITY_FUNCTIONS, SOCIAL_MEDIA,
    }

    public enum Locator implements OnixLocator {
        DROPDOWN_CATEGORY_MENU(By.cssSelector("#dropdownCategoryMenu")),
        SEARCH(By.cssSelector("[href='#/learn/search']")),
        BACK_ARROW(By.cssSelector(".back_link_arrow img")),

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
        CATEGORY_TAG_ITEM(By.cssSelector(".sub_category_menu_item")),
        SEE_ALL_ITEM(By.xpath("//a[text() = 'See All']")),



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
