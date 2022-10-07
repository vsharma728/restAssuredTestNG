package apiTests.pocTests;

import modules.ReportBuilder;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class GET_ApiTest extends ReportBuilder {

//    URL       https://reqres.in/
//    GET	    Fetch status line, Response body, Header etc. [200]
//    HEAD	    Same as GET, but only fetch status line and header section. [200]
//    POST	    Perform request using request payload mostly in creating a record at the server. [201]
//    PUT	    Useful in manipulating/updating the resource using Request payload. [200]
//    DELETE    Removes information relating to the target resource. [204]
//    OPTIONS	Describe the communication options for the target resource.
//    PATCH	    Very much similar to PUT, but it is more like a minor manipulation of resource content. [200]

    String url = "https://reqres.in/api/users?page=2";

    @Test(description = "GET-test1")
    public void getTest() {

        // With bdd approach
        given()
                .get(url)
                .then()
                .statusCode(200)
                .body("data.id[0]", equalTo(7))
                .body("data.first_name", hasItems("Michael", "Lindsay"))
                .log().all();
    }
}