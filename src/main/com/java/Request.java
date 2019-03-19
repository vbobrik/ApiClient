package main.com.java;


import static io.restassured.RestAssured.*;

import com.google.gson.JsonObject;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.testng.Assert;
import org.hamcrest.Matchers.*;
import com.jayway.restassured.RestAssured;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.*;
import static com.jayway.restassured.matcher.RestAssuredMatchers.*;

import org.apache.http.entity.ContentType;

import static com.jayway.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertNotNull;


public class Request {
    private String userName = "v.bobrik@kino-mo.com";
    private String password = "NIKita-1995.@";
    private String baseUrl = "https://stage-platform.kino-mo.com/api/admin/0/session";
    private String aaa = "__stripe_mid=46867503-6aec-46a5-ad14-e4e0b922b7f9; __cfduid=d38d48dc2a8397d49e45dd50dca9ea3791542312240; _ga=GA1.2.300201786.1542312241; _gid=GA1.2.1807524274.1552943447; __stripe_sid=b36272f6-03f8-4868-b4de-2ac9652cc7cf";
    private boolean isAdmin = true;
    private boolean rememberMe = false;


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
public String getClientById() {
    return given().log().all()
     .header("km-auth", "9b768a64f548730f9841de626b99132ccfaf25a6ff035fccf3609701ad9faf855ae9c2a9bde2b1cf8843a398")
            .header("Content-Type", "application/json")
            .when()
            .get("https://stage-platform.kino-mo.com" + "/api/admin/0/client/5c90ee8d0fb2d32bc288f0c5")
            .then()
            .assertThat()
            .log().all()
            .statusCode(200)
            .extract().body().toString();
}

    public String getToken1() {
        JsonObject loginCredentials = new JsonObject();
        loginCredentials.addProperty("userName", userName);
        loginCredentials.addProperty("password", password);
        //loginCredentials.addProperty("isAdmin", isAdmin);
        loginCredentials.addProperty("rememberMe", rememberMe);
        return given().log().all()
                //.header("km-auth", "9b768a64f548730f9841de626b99132ccfaf25a6ff035fccf3609701ad9faf855ae9c2a9bde2b1cf8843a398")
                .contentType("application/json")
                .body(loginCredentials)
                .when()
                .put(baseUrl)
                .then()
                .assertThat()
                .log().all()
                .statusCode(200)
                .extract().body().toString();

    }

    public String updateClient() {
        return given().log().all()
                .header("km-auth", "9b768a64f548730f9841de626b99132ccfaf25a6ff035fccf3609701ad9faf855ae9c2a9bde2b1cf8843a398")
                .header("Content-Type", "application/json")
                .when()
                .get("https://stage-platform.kino-mo.com" + "/api/admin/0/client/5c90ee8d0fb2d32bc288f0c5")
                .then()
                .assertThat()
                .log().all()
                .statusCode(200)
                .extract().body().toString();
    }

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
