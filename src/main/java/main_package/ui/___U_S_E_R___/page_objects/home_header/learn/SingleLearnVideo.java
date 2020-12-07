package main_package.ui.___U_S_E_R___.page_objects.home_header.learn;

import main_package.ui.BasePageObject;
import main_package.engine.test_engine.FlyTester;
import main_package.engine.OnixLocator;
import main_package.engine.OnixWebDriver;
import main_package.ui.___U_S_E_R___.general_parts.home.HomeHeaderPart;
import org.openqa.selenium.By;

public class SingleLearnVideo extends BasePageObject implements HomeHeaderPart {
    public SingleLearnVideo(OnixWebDriver driver) {
        super(driver);
    }
    @Override
    public SingleLearnVideo test(FlyTester flyTester) {
        flyTester.test();
        return this;
    }
    public Learn clickBackArrow() {
        driver.findElement(Locator.BACK_ARROW).click();
        return new Learn(driver);
    }

    public enum Locator implements OnixLocator {
        BACK_ARROW(By.cssSelector(".back_link_arrow img")),
        FAVOURITES_HEART_BUTTON(By.xpath("//button//div[text() = 'Favourites']")),
        COMPLETED_ICON_BUTTON(By.xpath("//button//div[text() = 'Completed']")),
        NEXT_VIDEO_LINK(By.cssSelector(".up_next_video a"))
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
        VIDEO_ITEM_FROM_LIST(By.cssSelector(".related_videos.container .related_videos_item_body")),


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

    class VideoIFrame extends BasePageObject {

        public VideoIFrame(OnixWebDriver driver) {
            super(driver);
        }
        @Override
        public VideoIFrame test(FlyTester flyTester) {
            flyTester.test();
            return this;
        }
    }
}
