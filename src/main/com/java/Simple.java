package main.com.java;

import static io.restassured.RestAssured.get;

import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.Test;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Date;
public class Simple {
//Пример посылки GET-запроса

        @Test(description = "GET")
        public void getRequestExampleTest() throws JSONException {
            Response response = get("http://restcountries.eu/rest/v1/name/russia");
            JSONArray jsonResponse = new JSONArray(response.asString());
            String capital = jsonResponse.getJSONObject(0).getString("capital");
            Assert.assertEquals(capital, "Moscow");
        }



    //Пример посылки POST-запроса
        @Test(description = "POST")
        public void postRequestExampleTest() {
            String someRandomString = String.format("%1$TH%1$TM%1$TS", new Date());

            JSONObject requestBody = new JSONObject();
            requestBody.put("FirstName", someRandomString);
            requestBody.put("LastName", someRandomString);
            requestBody.put("UserName", someRandomString);
            requestBody.put("Password", someRandomString);
            requestBody.put("Email", someRandomString + "@gmail.com");

            RequestSpecification request = RestAssured.given();
            request.header("Content-Type", "application/json");
            request.body(requestBody.toString());
            Response response = request.post("http://restapi.demoqa.com/customer/register");

            int statusCode = response.getStatusCode();
            Assert.assertEquals(statusCode, 201);
            String successCode = response.jsonPath().get("SuccessCode");
            Assert.assertEquals(successCode, "OPERATION_SUCCESS");
            System.out.println(response.getBody().asString());
        }


}
