package apiModules;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class APITestsPost {
    @Test
    public void validatePost() {
        Map<String, Object> map = new HashMap<String,Object>();

        map.put("name", "João");
        map.put("job", "Teacher");

        System.out.println(map);

        JSONObject request = new JSONObject(map);

        System.out.println(request.toJSONString());
    }

    @Test
    public void validatePostRefactor() {
        Map<String,Object> map = new HashMap<String,Object>();

        JSONObject request = new JSONObject(map);

        request.put("name", "João");
        request.put("job", "Software Engineer");

        baseURI = "https://reqres.in/api";
        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                body(request.toJSONString()).
                when().
                post("users").
                then().
                statusCode(201).
                log().all();
    }
}
