package apiModules;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class APITests {

    @Test
    public void validateReturnStatusCode() {
        Response response = RestAssured.get("https://reqres.in/api/users?page=2");
        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode, 200);
    }
}
