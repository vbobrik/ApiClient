package main.com.java;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;




    import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppsDeveloperBlog {
    private String userName = "v.bobrik@kino-mo.com";
    private String password = "NIKita-1995.@";
    private String baseUrl = "https://stage-platform.kino-mo.com";



        public void validate_response_headers_test() {
            RestAssured.baseURI = baseUrl;
            RequestSpecification httpRequest = RestAssured.given();
            httpRequest.header("Content-Type", "application/json");
            // Create new JSON Object
            JsonObject loginCredentials = new JsonObject();
            loginCredentials.addProperty("userName", userName);
            loginCredentials.addProperty("password", password);
            httpRequest.body(loginCredentials.toString());
            Response response = httpRequest.put("/login/api/admin/0/session");
            System.out.println(response);
            String authorizationHeader = response.getHeader("km-token");
           // Assert.assertNotNull(authorizationHeader);
        }

}
