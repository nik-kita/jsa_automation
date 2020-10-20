package ui.user_mode.page_objects;


import org.openqa.selenium.By;
import ui.BasePageObject;
import ui.engine.OnixLocator;
import ui.engine.OnixWebDriver;
import ui.user_mode.general_parts.Footer;
import ui.user_mode.general_parts.HomeHeader;

public class Home extends BasePageObject implements Footer, HomeHeader {
    public Home(OnixWebDriver driver) {
        super(driver);
    }

    public UserCabinetDropdown openUserDropDown() {
        driver.findElement(HeaderLocator.MY_CABINET_DROPDOWN).click();
        return new UserCabinetDropdown(driver);
    }

    public Main goMainPage() {
        driver.findElement(HeaderLocator.JSA_LOGO).click();
        return new Main(driver);
    }


    public enum Locator implements OnixLocator {
        MY_PLAN_IMG_LINK(By.cssSelector("[href='/users/account/my-plan")),
        GET_STARTED_6_STEPS_DIV_LINK(By.cssSelector("[href='#/home/step-two']")),
        MY_GOAL_DIV_LINK(By.cssSelector("[href='#/home/my-goal']")),
        STEPS_DIV_LINK(By.cssSelector("[href='#/home/steps']")),
        EDIT_IMG_BTM_IN_STEPS_DIV(By.cssSelector(".todays_steps img")),
        MY_PROGRESS_DIV_LINK(By.cssSelector("[href='#/home/my-progress']")),
        CHALLENGE_DIV_LINK(By.cssSelector("[href='#/home/challenges']")),
        UPGRADE_TO_ACCESS_BTN(By.cssSelector(".facebook_group [href='/users/pricing/']")),
        SUPPORT_BUTTON(By.xpath("//button[contains(text(), 'Support')]")),


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
