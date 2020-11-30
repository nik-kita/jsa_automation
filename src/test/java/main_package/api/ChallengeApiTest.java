package main_package.api;

import io.restassured.response.Response;
import main_package.api.clients.ChallengeClient;
import main_package.api.models.Challenge;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ChallengeApiTest extends BaseApiTestRunner{
    ChallengeClient challengeClient;
    @BeforeClass
    public void beforeChallengeTests() {
        challengeClient = new ChallengeClient(new Challenge(), user);
    }
    @Test
    public void getChallengeTest() {
        Response response = challengeClient.getChallenge();
        System.out.println(response.prettyPrint());
    }

}
