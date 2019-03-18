package main.com.java;

public class Main {
    public static void main(String[] args) {
        Request request = new Request();
        //request.authenticate();
        System.out.println( request.getToken());
    }
}
