package main_package.ui.user_mode.page_objects.home_header.home.my_goal;

import main_package.ui.engine.*;
import org.openqa.selenium.By;
import main_package.ui.BasePageObject;
import main_package.ui.user_mode.general_parts.home.HomeHeaderPart;
import main_package.ui.user_mode.page_objects.home_header.home.Home;

public class MyGoal extends BasePageObject implements HomeHeaderPart {
    public MyGoal(OnixWebDriver driver) {
        super(driver);
        logger.debug("'MyGoal' page is open.");
    }
    @Override
    public MyGoal test(FlyTester flyTester) {
        flyTester.test();
        return this;
    }
    public OnixLocator optionInGoalSelect = makeOnixLocator(By.cssSelector("select[name='goalCategory'] option"), this.getClass());
    public OnixLocator weeklyGoal = makeOnixLocator(By.className("weekly_goal_list_item"), this.getClass());
    public OnixLocator doneActive = makeOnixLocator(By.xpath("//img[contains(@src, 'bt_done.svg')]"), this.getClass());
    public OnixLocator doneGray = makeOnixLocator(By.xpath("//img[contains(@src, 'bt_done_gray')]"), this.getClass());

    public boolean hasWeeklyGoal() {
        boolean result = driver.isElementPresent(weeklyGoal);
        if(result) {
            logger.debug("page has weeklyGoal");
        } else {
            logger.debug("no weeklyGoal elements on page");
        }
        return result;
    }
    public int amountOfWeeklyGoals () {
        int result = driver.findElements(weeklyGoal).size();
        logger.debug("there are " + result + " weeklyGoals on the page");
        return result;
    }
    public MyGoal clickAcceptWeeklyGoal(String name) {
        OnixWebElement e = driver.findElement(By.xpath(String.format("//p[contains(text(), '%s')]/../../..", name)));
        e.findElementInsideThis(By.cssSelector("img.save_goal")).click();
        logger.debug("accept weeklyGoal that contains '" + name + "' word");
        return this;
    }
    public MyGoal clickDeleteWeeklyGoal(String name) {
        By pathToWeeklyGoal = By.xpath(String.format("//p[contains(text(), '%s')]/../../..", name));
        OnixWebElement e = driver.findElement(pathToWeeklyGoal);
        e.findElementInsideThis(By.cssSelector("img.delete_goal")).click();
        driver.alertAccept();
        if(driver.isElementPresent(pathToWeeklyGoal)) {
            driver.waitInvisibilityOf(e);
        }
        logger.debug("delete weeklyGoal that contains '" + name + "' word by accepting delete alert");
        return this;
    }
    public MyGoal clickAcceptWeeklyGoal(int number) {
        OnixWebElement e = driver.findElements(weeklyGoal).get(number);
        e = e.findElementInsideThis(By.cssSelector("img.save_goal"));
        e.click();
        logger.debug("accept weeklyGoal number " + number);
        return this;
    }
    public MyGoal clickDeleteWeeklyGoal(int number) {
        int before = amountOfWeeklyGoals();
        OnixWebElement e = driver.findElements(weeklyGoal).get(number);
        e.findElementInsideThis(By.cssSelector("img.delete_goal")).click();
        driver.alertAccept();
        if(before == amountOfWeeklyGoals()) {
            driver.waitInvisibilityOf(e);
        }
        logger.debug("delete weeklyGoal number " + number + " by accepting delete alert");
        return this;
    }
    public MyGoal removeAllWeeklyGoals() {
        for(OnixWebElement e : driver.findElements(weeklyGoal)) {
            e.findElementInsideThis(By.cssSelector("img.delete_goal")).click();
            driver.alertAccept();
        }
        logger.debug("delete all weeklyGoal on page");
        return this;
    }


    public Home clickBackArrow() {
        driver.findElement(Locator.BACK_ARROW).click();
        logger.debug("'Home' from 'MyGoal'");
        return new Home(driver);
    }
    public MyGoal selectGoalByString(String select) {
        driver.findElement(Locator.GOAL_SELECT).click();
        for(OnixWebElement e : driver.findElements(optionInGoalSelect)) {
            if(e.text().equals(select)) {
                e.click();
                break;
            }
        }
        logger.debug("select goal that contains '" + select + "' in name");
        return this;
    }
    public MyGoal selectGoal(int number) {
        driver.findElement(Locator.GOAL_SELECT).click();
        driver.findElements(optionInGoalSelect).get(number).click();
        logger.debug("select goal number " + number);
        return this;
    }
    public MyGoal selectGoal() {
        return selectGoal(0);
    }
    public MyGoal fillMoreDetailTextarea(String text) {
        OnixWebElement textarea = driver.findElement(Locator.MORE_DETAIL_TEXTAREA);
        textarea.click();
        textarea.getSeleniumWebElement().clear();
        textarea.sendKeys(text);
        logger.debug("fill 'more details' textarea with text:\n" + text);
        return this;
    }
    public MyGoal clickSaveButton() {
        driver.findElement(Locator.SAVE_BUTTON).click();
        return this;
    }
    public NewWeeklyGoal clickNewGoalButton() {
        driver.findElement(Locator.NEW_GOAL_BUTTON).click();
        logger.info("Click on 'New Goal' button.");
        return new NewWeeklyGoal(driver);
    }

    public NewWeeklyGoal clickNewGoalButton(OnixAssert onixAssert) {
        driver.findElement(Locator.NEW_GOAL_BUTTON).click();
        logger.info("Click on 'New Goal' button.");
        for(OnixLocator l : NewWeeklyGoal.Locator.values()) {
            onixAssert.softCheckCountOfElementByLocator(l, 1);
        }
        return new NewWeeklyGoal(driver);
    }


    public enum Locator implements OnixLocator {
        BACK_ARROW(By.xpath("//img[contains(@src, 'ic_back_purple')]")),
        GOAL_SELECT(By.cssSelector("select[name='goalCategory']")),
        MORE_DETAIL_TEXTAREA(By.cssSelector("textarea[name='goal']")),
        SAVE_BUTTON(By.xpath("//button[contains(text(), 'Save')]")),
        NEW_GOAL_BUTTON(By.xpath("//div[contains(@class, 'weekly_goal_list')]//button[text()='New Goal']")),


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
        WEEKLY_GOAL_LIST_ITEM_P(By.cssSelector(".weekly_goal_list_item p")),

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
