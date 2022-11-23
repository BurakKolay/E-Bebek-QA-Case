package tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class RestAssuredTest {



    @Test
    public void getClients(){
        when().get("https://generator.swagger.io/api/gen/clients")
                .then()
                .statusCode(200);

    }

    @Test
    public void postLanguage(){
        String postData = "{\n" +
                "\"swaggerUrl\": \"http://petstore.swagger.io/v2/swagger.json\"" +
                "}";

        given()
                .contentType(ContentType.JSON)
                .body(postData)
                .when()
                .post("https://generator.swagger.io/api/gen/clients/java")
                .then()
                .statusCode(200);
    }

}
