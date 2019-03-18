package main.com.java;


import org.hamcrest.Matchers.*;
import com.jayway.restassured.RestAssured;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.*;
import static com.jayway.restassured.matcher.RestAssuredMatchers.*;
import static junit.framework.Assert.assertNotNull;

import org.apache.http.entity.ContentType;

import static com.jayway.restassured.RestAssured.given;


public class Request {
    private String userName = "v.bobrik@kino-mo.com";
    private String password = "NIKita-1995.@";
    private String baseUrl = "https://stage-platform.kino-mo.com/#/admin/login/api/admin/0/session";


    public String getToken()

    {
        return given().log().all().
                auth().
                preemptive().
                basic(userName, password).
                when().
                get(baseUrl).
                then().
                assertThat().
                statusCode(200)
                .extract().body().toString();

    }

  /*  public void GetToken() {
        PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
        authScheme.setUserName("login");
        authScheme.setPassword("password");
        RestAssured.authentication = authScheme;
    }*/


    public void authenticate() {
Credentials credentials = new Credentials();

        AuthenticationToken authenticationToken =

                given()
                        .contentType("application/json")
                        .body(credentials)
                        .expect()
                        .statusCode(200)
                        .when()
                        .put("/login")
                        .then()
                        .log().all()
                        .extract()
                        .body().as(AuthenticationToken.class);

        assertNotNull(authenticationToken.getAuthToken());

    }
}
