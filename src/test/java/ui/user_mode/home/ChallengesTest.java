package ui.user_mode.home;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ui.engine.OnixLocator;
import ui.guest_mode.page_objects.main.Challenge;
import ui.user_mode.JsaLoginBaseTestRunner;
import ui.user_mode.general_parts.home.HomeHeaderPart;
import ui.user_mode.page_objects.home_header.home.Challenges;

public class ChallengesTest extends JsaLoginBaseTestRunner {
    @BeforeClass
    public void goChallengesInHome() {
        homeLoginModePO.clickChallenges();
    }
    @Test(dataProvider = "getChallengesLocators")
    public void challengesTest(OnixLocator locator) {
        onixAssert.checkCountOfElementByLocator(locator, 1);
    }
    @DataProvider
    public Object[] getChallengesLocators() {
        return mergeArrays(
                Challenges.HomeHeaderLocator.values(),
                Challenges.Locator.values()
        );
    }
}
