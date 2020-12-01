package main_package.ui.user_mode.main;

import main_package.ui.user_mode.JsaLoginBaseUiTestRunner;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.engine.test_engine.OnixUiAssert;
import main_package.engine.OnixLocator;
import main_package.ui.user_mode.page_objects.main.Challenge;

public class ChallengeUiTest extends JsaLoginBaseUiTestRunner {

    @BeforeClass
    public void goChallengePage() {
        homeLoginModePO.goMainPage().goChallengePage();
    }

    @Test(dataProvider = "getChallengePageLocators")
    public void challengePageTest(OnixLocator locator) {
        new OnixUiAssert(getDriver()).
                checkCountOfElementByLocator(locator, 1);
    }

    @DataProvider
    public Object[] getChallengePageLocators() {
        return mergeArrays(Challenge.Locator.values(),
                Challenge.HeaderLocator.values(),
                Challenge.FooterLocator.values()
        );
    }
}
