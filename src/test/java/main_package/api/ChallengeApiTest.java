package main_package.api;

import io.restassured.internal.http.Status;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import main_package.api.assertions.ChallengeAssert;
import main_package.api.clients.ChallengeClient;
import main_package.api.models.Challenge;
import main_package.engine.db.ChallengeDb;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class ChallengeApiTest extends BaseApiTestRunner {
    ChallengeClient challengeClient;
    ChallengeAssert challengeAssert;
    ChallengeDb challengeDb;
    Map<Integer, Challenge> expectedMap;
    @BeforeClass
    public void beforeChallengeTests() {
        challengeClient = new ChallengeClient(new Challenge(), user);
        challengeAssert = new ChallengeAssert();
        challengeDb = new ChallengeDb();
        expectedMap = challengeDb.selectAll();
    }
    @Test
    public void getChallengeTest() {
        Response response = challengeClient.getChallenge();
        JsonPath jsonPath = response.jsonPath();
        Map<Integer, Challenge> actualMap = Challenge.getMap(jsonPath.getList("$", Challenge.class));
        challengeAssert
                .softCheckChallengeMaps(actualMap, expectedMap)
                .softCheckStatusCode(response.getStatusCode(), 200)
                .assertAll();
    }

}
