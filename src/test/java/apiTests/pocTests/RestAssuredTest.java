package apiTests.pocTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import modules.ReportBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RestAssuredTest extends ReportBuilder {

//    URL       https://reqres.in/
//    GET	    Fetch status line, Response body, Header etc. [200]
//    HEAD	    Same as GET, but only fetch status line and header section. [200]
//    POST	    Perform request using request payload mostly in creating a record at the server. [201]
//    PUT	    Useful in manipulating/updating the resource using Request payload. [200]
//    DELETE    Removes information relating to the target resource. [204]
//    OPTIONS	Describe the communication options for the target resource.
//    PATCH	    Very much similar to PUT, but it is more like a minor manipulation of resource content. [200]

    String url = "https://reqres.in/api/users?page=2";

    @Test(description = "test1")
    public void responseClassTest() {

        // With rest assured class
        Response response = RestAssured.get(url);

        System.out.println(response.asString());
        System.out.println(response.getHeader("content-type"));
        System.out.println(response.getTime());

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }
}