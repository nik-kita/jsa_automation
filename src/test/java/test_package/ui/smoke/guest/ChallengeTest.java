package test_package.ui.smoke.guest;

import main_package.engine.test_engine.OnixUiTestRunner;
import main_package.ui.___G_U_E_S_T___.page_objects.main.Challenge;
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
