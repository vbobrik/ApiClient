package main.com.java;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static ArrayList<String> arrayList = new ArrayList<>();

    public static void main(String[] args) {
        Request request = new Request();
//       DefaultLocation.setCoordinates();
//        DefaultLocation client1Location = new DefaultLocation( "EU", "87");
        Client client0 = new Client("Gosha", "Got", "Minsk", arrayPhone(), arrayEmail());
        Client client1 = new Client("Gosha2", "Got", "Minsk", arrayPhone(), arrayEmail());
        Client client2 = new Client("Gosha3", "Got", "Minsk", arrayPhone(), arrayEmail());
        System.out.println("******GET TOKEN");
        System.out.println(request.getToken());
        System.out.println("******GET CLIENT BY ID");
        System.out.println(request.getClientById("5c90ee8d0fb2d32bc288f0c5"));
        System.out.println("*********CREATE CLIENT");
        request.createClient(client1);
        System.out.println("******* UPDATE CLIENT");
        System.out.println(request.updateClient(client1));
        System.out.println("******* DELETE CLIENT");
        System.out.println(request.deleteClient("5c97dccecbc5371e9dc3f70c"));

        //request.postRequestExampleTest1();
//        Simple simple = new Simple();
        //  simple.putRequestExampleTest();

        // AppsDeveloperBlog a = new AppsDeveloperBlog();
        // a.validate_response_headers_test();

    }

    public static ArrayList<String> arrayPhone() {
        arrayList.add(0, "123123");
        return arrayList;
    }

    public static ArrayList<String> arrayEmail() {
        arrayList.add(0, "test@jk.ru");
        return arrayList;
    }
}
