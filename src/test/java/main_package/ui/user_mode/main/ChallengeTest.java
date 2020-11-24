package main_package.ui.user_mode.main;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.ui.engine.OnixAssert;
import main_package.ui.engine.OnixLocator;
import main_package.ui.user_mode.page_objects.main.Challenge;
import main_package.ui.user_mode.JsaLoginBaseTestRunner;

public class ChallengeTest extends JsaLoginBaseTestRunner {

    @BeforeClass
    public void goChallengePage() {
        homeLoginModePO.goMainPage().goChallengePage();
    }

    @Test(dataProvider = "getChallengePageLocators")
    public void challengePageTest(OnixLocator locator) {
        new OnixAssert(getDriver()).
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
