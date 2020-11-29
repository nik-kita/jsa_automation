package main_package.api;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserApiTest extends BaseApiTestRunner {

    @Test
    public void getCoachIdleTest() {
        Response response = userClient.getCoachIdle();
        logger.info(response.prettyPrint());
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void patchCoachIdle_id_Test() {
        Response response = userClient.patchCoachIdle_id();
        logger.info(response.prettyPrint());
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void getCoachProfileTest() {
        Response response = userClient.getCoachProfile();
        logger.info(response.prettyPrint());
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void postCoachProfileTest() {
        Response response = userClient.postCoachProfile();
        logger.info(response.prettyPrint());
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
