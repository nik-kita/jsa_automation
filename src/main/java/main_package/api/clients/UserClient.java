package main_package.api.clients;

import io.restassured.response.Response;
import main_package.api.models.User;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class UserClient extends BaseClient {

    String token;

    public String generateToken(User user) {
        Map<String, String> forBody = new HashMap<>();
        forBody.put("grant_type", "password");
        forBody.put("username", user.getUsername());
        forBody.put("password", user.getPassword());
        forBody.put("scope", "read");
        forBody.put("client_id", getClientId());
        forBody.put("client_secret", getClientSecret());
        Response response = given(baseRequestSpecification()).queryParams(forBody).post("/o/token/");
        System.out.println(response.toString());
        return response.path("token_type") + " " + response.path("access_token");
    }

}
