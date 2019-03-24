package main.com.java;


import static io.restassured.RestAssured.*;

import com.google.gson.JsonObject;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import org.apache.http.entity.ContentType;

import java.util.ArrayList;
import java.util.Date;

import static org.testng.AssertJUnit.assertNotNull;


public class Request {
    private String userName = "v.bobrik@kino-mo.com";
    private String password = "NIKita-1995.@";
    private String baseUrl = "https://stage-platform.kino-mo.com/api/admin/0";
    //   private String aaa = "__stripe_mid=46867503-6aec-46a5-ad14-e4e0b922b7f9; __cfduid=d38d48dc2a8397d49e45dd50dca9ea3791542312240; _ga=GA1.2.300201786.1542312241; _gid=GA1.2.1807524274.1552943447; __stripe_sid=b36272f6-03f8-4868-b4de-2ac9652cc7cf";

    public String getToken() {
        Response token = given().contentType("application/json")
                .get(baseUrl + "/session");

        if (token.jsonPath().getInt("status") == 200) {
            return token.jsonPath().getString("message.sessionToken");
        } else {

            JsonObject credentials = new JsonObject();
            credentials.addProperty("password", password);
            credentials.addProperty("username", userName);

            Response response = given()
                    .contentType("application/json")
                    .body(credentials)
                    .put(baseUrl + "/session");

            return response.jsonPath().getString("message.sessionToken");
        }
    }

    public Client getClientById(String clientId) {
//        return given().log().all()
        Response response = given()
                .header("km-auth", getToken())
                .header("Content-Type", "application/json")
//                .when()
                .get(baseUrl + "/client/" + clientId);
//                .then()
//                .assertThat()
//                .log().all()
//                .statusCode(200)
//                .extract().body().toString();
//        return response.getBody().asString();

        Client unknown = response.getBody().as(Client.class);
        return unknown;
    }

    public void createClient(Client client) {
        getToken();
        Response response = given()
                .header("km-auth", getToken())
                .contentType("application/json")
                .body(client)
                .put(baseUrl + "/client");
        System.out.println(response.getBody().as(Client.class).get_id());

    }

    public String updateClient(Client client) {
        return given()
                .header("km-auth", getToken())
                .header("Content-Type", "application/json")
                .body(client)
                .when()
                .post(baseUrl + "/client/" + client.get_id())
                .getBody().asString();
    }

    public String deleteClient(String id) {
        return given()
                .header("km-auth", getToken())
                .header("Content-Type", "application/json")
                .delete(baseUrl + "/client/" + id)
                .getBody().asString();

    }

//    public void authenticate() {
//        Credentials credentials = new Credentials();
//
//        AuthenticationToken authenticationToken =
//
//                given()
//                        .contentType("application/json")
//                        .body(credentials)
//                        .expect()
//                        .statusCode(200)
//                        .when()
//                        .put("/login")
//                        .then()
//                        .log().all()
//                        .extract()
//                        .body().as(AuthenticationToken.class);
//
//        assertNotNull(authenticationToken.getAuthToken());
//
//    }
//
//    public void postRequestExampleTest1() {
//
//
//        JSONObject jsonObj = new JSONObject()
//                .put("username", userName)
//                .put("password", password);
//
//
//        RequestSpecification request1 = given()
//                .when()
//                .contentType("application/json")
//                .body(jsonObj);
//        Response response1 = put(baseUrl);
//        System.out.println(response1.getBody().print());
//



     /*   JsonObject jsonPath = given()
                        .contentType("application/json") //another way to specify content type
                        .body(jsonObj.toString()) // use jsonObj toString method
                        .when()
                        .put("https://test02-platform.kino-mo.com/api/user/0/session")

        String a = jsonPath.getString("message.sessionToken");
        System.out.println(a);
    */
}

//    public String simlpleToken() {
//
//        JsonObject credentials = new JsonObject();
//        credentials.addProperty("password", password);
//        credentials.addProperty("username", userName);
//
//        Response response = given()
//                .contentType("application/json")
//                .body(credentials)
//                .put(baseUrl);
//
//        return response.jsonPath().getString("message.sessionToken");

//    TokenResponse r = response.getBody().as(TokenResponse.class);

//    String token = response.getBody().asString();
//
//    return token;

//    return r.getMessage().getSessionToken();




