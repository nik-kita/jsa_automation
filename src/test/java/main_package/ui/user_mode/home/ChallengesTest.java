package main_package.ui.user_mode.home;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.engine.OnixLocator;
import main_package.ui.user_mode.JsaLoginBaseTestRunner;
import main_package.ui.user_mode.page_objects.home_header.home.Challenges;

public class ChallengesTest extends JsaLoginBaseTestRunner {
    @BeforeClass
    public void goChallengesInHome() {
        homeLoginModePO.clickChallenges();
    }
    @Test(dataProvider = "getChallengesLocators")
    public void challengesTest(OnixLocator locator) {
        onixUiAssert.checkCountOfElementByLocator(locator, 1);
    }
    @DataProvider
    public Object[] getChallengesLocators() {
        return mergeArrays(
                Challenges.HomeHeaderLocator.values(),
                Challenges.Locator.values()
        );
    }
}
