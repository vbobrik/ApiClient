package main.com.java;

import java.util.ArrayList;

public class DefaultLocation {
    private static ArrayList<Double> coordinates;
    private  String type;
    private String countryCode;
//    private Object location = {type: "Point", coordinates: [53.90453979999999, 27.561524400000053], countryCode: "by"};

    public static ArrayList<Double> getCoordinates(Double number1, Double number2) {
        addCoordinates(number1, number2);
        return coordinates;
    }

    public static void setCoordinates(ArrayList<Double> coordinates) {
        DefaultLocation.coordinates = coordinates;
    }

    public DefaultLocation(String type, String countryCode) {
        this.coordinates = coordinates;
        this.type = type;
        this.countryCode = countryCode;
    }

    public static void  addCoordinates(Double number1, Double number2) {
        coordinates.add(number1);
        coordinates.add(number2);
    }
}
