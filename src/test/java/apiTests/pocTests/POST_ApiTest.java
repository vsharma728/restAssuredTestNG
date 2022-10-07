package apiTests.pocTests;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class POST_ApiTest extends ApiTestDataProvider {

//    URL       https://reqres.in/
//    GET	    Fetch status line, Response body, Header etc. [200]
//    HEAD	    Same as GET, but only fetch status line and header section. [200]
//    POST	    Perform request using request payload mostly in creating a record at the server. [201]
//    PUT	    Useful in manipulating/updating the resource using Request payload. [200]
//    DELETE    Removes information relating to the target resource. [204]
//    OPTIONS	Describe the communication options for the target resource.
//    PATCH	    Very much similar to PUT, but it is more like a minor manipulation of resource content. [200]

    @Test(dataProvider = "TestData1")
    public void postTest(String name, String job) {

        JSONObject request = new JSONObject();
        request.put(name, job);

        System.out.println(request);
        System.out.println(request.toJSONString());

        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString()).
                when()
                .post("https://reqres.in/api/users").
                then()
                .statusCode(201);
    }

    @Parameters({"name", "job"}) // fetch data from testng_api_parameters.xml file
    @Test
    public void postTest2(String name, String job) {

        JSONObject request = new JSONObject();

        request.put(name, job);

        System.out.println(request);
        System.out.println(request.toJSONString());

        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString()).
                when()
                .post("https://reqres.in/api/users").
                then()
                .statusCode(201);
    }
}