package test_package.ui.smoke.guest;

import main_package.engine.test_engine.OnixUiTestRunner;
import main_package.ui.guest_mode.page_objects.main.Challenge;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChallengeTest extends OnixUiTestRunner {
    Challenge challenge;
    @BeforeMethod
    public void openChallenge() {
        challenge = openSite().clickHeaderChallenge();
    }
    @Test
    public void challengeTest() {
        challenge.check(onixUiAssert);
        onixUiAssert.assertAll();
    }


}