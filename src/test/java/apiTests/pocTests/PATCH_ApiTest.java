package apiTests.pocTests;

import io.restassured.http.ContentType;
import modules.ReportBuilder;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PATCH_ApiTest extends ReportBuilder {

    //    URL       https://reqres.in/
//    GET	    Fetch status line, Response body, Header etc. [200]
//    HEAD	    Same as GET, but only fetch status line and header section. [200]
//    POST	    Perform request using request payload mostly in creating a record at the server. [201]
//    PUT	    Useful in manipulating/updating the resource using Request payload. [200]
//    DELETE    Removes information relating to the target resource. [204]
//    OPTIONS	Describe the communication options for the target resource.
//    PATCH	    Very much similar to PUT, but it is more like a minor manipulation of resource content. [200]

    @Test(description = "PATCH-test1")
    public void patchTest() {

        JSONObject request = new JSONObject();

        request.put("name", "Team");
        request.put("job", "Engineering");

        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString()).
                when()
                .patch("https://reqres.in/api/users/2").
                then()
                .statusCode(200)
                .log().all();
    }
}