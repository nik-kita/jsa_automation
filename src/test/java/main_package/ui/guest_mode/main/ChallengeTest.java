package main_package.ui.guest_mode.main;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.engine.test_engine.OnixTestRunner;
import main_package.engine.OnixLocator;
import main_package.ui.guest_mode.page_objects.main.Challenge;

public class ChallengeTest extends OnixTestRunner {

    @BeforeClass
    public void goChallengePage() {
        openSite().goChallengePage();
    }

    @Test(dataProvider = "getChallengePageLocators")
    public void challengePageTest(OnixLocator locator) {
        onixUiAssert.
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
