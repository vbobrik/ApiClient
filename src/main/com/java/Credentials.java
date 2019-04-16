package main.com.java;

import com.google.gson.JsonObject;

public class Credentials {
    private static String userName = "";
    private static String password = "";

    public static JsonObject credentialsAsJson() {
        JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("password", password);
                jsonObject.addProperty("username", userName);
        return jsonObject;
    }
}
