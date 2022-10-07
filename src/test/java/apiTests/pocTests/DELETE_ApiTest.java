package apiTests.pocTests;

import modules.ReportBuilder;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;

public class DELETE_ApiTest extends ReportBuilder {

//    URL       https://reqres.in/
//    GET	    Fetch status line, Response body, Header etc. [200]
//    HEAD	    Same as GET, but only fetch status line and header section. [200]
//    POST	    Perform request using request payload mostly in creating a record at the server. [201]
//    PUT	    Useful in manipulating/updating the resource using Request payload. [200]
//    DELETE    Removes information relating to the target resource. [204]
//    OPTIONS	Describe the communication options for the target resource.
//    PATCH	    Very much similar to PUT, but it is more like a minor manipulation of resource content. [200]

    @Test(description = "DELETE-test1")
    public void deleteTest() {

        when()
                .delete("https://reqres.in/api/users/2").
                then()
                .statusCode(204)
                .log().all();
    }
}