package main.com.java;

import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Client {
    private String _id;
    private String name;
    private String legalName;
    private String defaultLocation;
    private ArrayList<String> phone;
    private ArrayList<String> email;
//    private DefaultLocation defaultLocation;
//   private DefaultLocation location = {type: "Point", coordinates: [53.90453979999999, 27.561524400000053], countryCode: "by"};

    public Client(String name, String legalName, String  defaultLocation, ArrayList<String> phone, ArrayList<String> email) {
        this.name = name;
        this.legalName = legalName;
        this.defaultLocation = defaultLocation;
        this.phone = phone;
        this.email = email;
//        JsonObject body = new JsonObject();
//        body.addProperty("name", name);
//        body.addProperty("legalName", legalName);
//        body.addProperty("defaultLocation", defaultLocation);
//        body.addProperty("phone", phone);
//        body.addProperty("email", email);
    }

    public Client() {

    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLegalName() {
        return legalName;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

//    public String getDefaultLocation() {
//        return defaultLocation;
//    }
//
//    public void setDefaultLocation(String defaultLocation) {
//        this.defaultLocation = defaultLocation;
//    }

    public ArrayList<String> getPhone() {
        return phone;
    }

    public void setPhone(ArrayList<String> phone) {
        this.phone = phone;
    }

    public ArrayList<String> getEmail() {
        return email;
    }

    public void setEmail(ArrayList<String> email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Client{" +
                "_id='" + _id + '\'' +
                ", name='" + name + '\'' +
                ", legalName='" + legalName + '\'' +
                ", defaultLocation='" + defaultLocation + '\'' +
                ", phone=" + phone +
                ", email=" + email +
                '}';
    }

//    public JsonObject clientInJson() {
////
////    {
////        "name":"testtest",
////            "legalName":"tes",
////            "legalAddress":"",
////            "phone":[
////        "234234"
////   ],
////        "skype":[
////
////   ],
////        "email":[
////        "234@dfg.ru"
////   ],
////        "description":"",
////            "status":"active",
////            "media":{
////        "needAdminApprove":true,
////                "monthLimit":0,
////                "spaceLimit":0
////    },
////        "campaign":{
////        "monthLimit":0
////    },
////        "allowedPermissions":[
////
////   ],
////        "publicDevicesPeriod":{
////        "startDate":"",
////                "endDate":""
////    },
////        "maxDevices":0,
////            "deviceOwnership":"private",
////            "defaultLocation":{
////        "type":"Point",
////                "coordinates":[
////        53.90453979999999,
////                27.561524400000053
////      ],
////        "countryCode":"by"
////    },
////        "period":{
////        "startTime":null,
////                "endTime":null
////    },
////        "mobilePeriod":{
////        "startDate":null,
////                "endDate":null
////    },
////        "desktopPeriod":{
////        "startDate":null,
////                "endDate":null
////    },
////        "appType":"None",
////            "certifiedStudio":{
////        "isCertifiedStudio":null,
////                "studioClients":[
////
////      ],
////        "recentClients":[
////
////      ],
////        "studioFee":0,
////                "currency":"usd"
////    }
////    }

}
