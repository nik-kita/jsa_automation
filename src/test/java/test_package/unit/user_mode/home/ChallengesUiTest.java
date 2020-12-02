package test_package.unit.user_mode.home;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.engine.OnixLocator;
import main_package.ui.user_mode.page_objects.home_header.home.Challenges;
import main_package.engine.test_engine.JsaLoginBaseUiTestRunner;

public class ChallengesUiTest extends JsaLoginBaseUiTestRunner {
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
