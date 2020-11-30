package main_package.api.clients;


import io.restassured.response.Response;
import main_package.api.models.Challenge;
import main_package.api.models.User;

import static io.restassured.RestAssured.given;

public class ChallengeClient extends BaseClient {
    private Challenge challenge;
    private User user;
    private static String challenge_url = "/challenge";
    private static String get_challenge = challenge_url + "/challenge/";
    public ChallengeClient(Challenge challenge, User user) {
        this.challenge = challenge;
        this.user = user;
    }

    public Response getChallenge() {
        return given(baseRequestSpecification(user)).get(get_challenge);
    }

}
