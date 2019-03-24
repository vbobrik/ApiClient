package main.com.java;

import com.google.gson.JsonObject;

public class Credentials {
    private static String userName = "v.bobrik@kino-mo.com";
    private static String password = "NIKita-1995.@";

    public static JsonObject credentialsAsJson() {
        JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("password", password);
                jsonObject.addProperty("username", userName);
        return jsonObject;
    }
}
