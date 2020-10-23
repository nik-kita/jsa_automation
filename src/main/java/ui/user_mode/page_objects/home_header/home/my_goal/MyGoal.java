package ui.user_mode.page_objects.home_header.home.my_goal;

import org.openqa.selenium.By;
import ui.BasePageObject;
import ui.BasePart;
import ui.engine.OnixLocator;
import ui.engine.OnixWebDriver;
import ui.engine.OnixWebElement;
import ui.user_mode.general_parts.home.HomeHeaderPart;
import ui.user_mode.page_objects.home_header.home.Home;

public class MyGoal extends BasePageObject implements HomeHeaderPart {
    public MyGoal(OnixWebDriver driver) {
        super(driver);
    }
    public OnixLocator optionInGoalSelect = OnixLocator.makeOnixLocator(By.cssSelector("select[name='goalCategory'] option"));
    public OnixLocator weeklyGoal = OnixLocator.makeOnixLocator(By.className("weekly_goal_list_item"));

    public boolean hasWeeklyGoal() {
        return driver.isElementPresent(weeklyGoal);
    }
    public int amountOfWeeklyGoals () {
        return driver.findElements(weeklyGoal).size();
    }
    public MyGoal clickAcceptWeeklyGoal(String name) {
        OnixWebElement e = driver.findElement(By.xpath(String.format("//p[contains(text(), '%s')]/../../..", name)));
        e.findElementInsideThis(By.cssSelector("img.save_goal")).click();
        return this;
    }
    public MyGoal clickDeleteWeeklyGoal(String name) {
        OnixWebElement e = driver.findElement(By.xpath(String.format("//p[contains(text(), '%s')]/../../..", name)));
        e.findElementInsideThis(By.cssSelector("img.delete_goal")).click();
        driver.alertAccept();
        return this;
    }
    public MyGoal clickAcceptWeeklyGoal(int number) {
        OnixWebElement e = driver.findElements(weeklyGoal).get(number);
        e.findElementInsideThis(By.cssSelector("img.save_goal")).click();
        return this;
    }
    public MyGoal clickDeleteWeeklyGoal(int number) {
        OnixWebElement e = driver.findElements(weeklyGoal).get(number);
        e.findElementInsideThis(By.cssSelector("img.delete_goal")).click();
        driver.alertAccept();
        return this;
    }
    public MyGoal removeAllWeeklyGoals() {
        for(OnixWebElement e : driver.findElements(weeklyGoal)) {
            e.findElementInsideThis(By.cssSelector("img.delete_goal")).click();
            driver.alertAccept();
        }
        return this;
    }


    public Home clickBackArrow() {
        driver.findElement(Locator.BACK_ARROW).click();
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
        return this;
    }
    public MyGoal selectGoal(int number) {
        driver.findElement(Locator.GOAL_SELECT).click();
        driver.findElements(optionInGoalSelect).get(number).click();
        return this;
    }
    public MyGoal selectGoal() {
        return selectGoal(0);
    }
    public MyGoal fillMoreDetailTextarea(String text) {
        OnixWebElement textarea = driver.findElement(Locator.MORE_DETAIL_TEXTAREA);
        textarea.click();
        textarea.sendKeys(text);
        return this;
    }
    public MyGoal clickSaveButton() {
        driver.findElement(Locator.SAVE_BUTTON).click();
        return this;
    }
    public NewWeeklyGoal clickNewGoalButton() {
        driver.findElement(Locator.NEW_GOAL_BUTTON).click();
        return new NewWeeklyGoal(driver);
    }


    public enum Locator implements OnixLocator {
        BACK_ARROW(By.cssSelector("[href='#/hom']")),
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
}
