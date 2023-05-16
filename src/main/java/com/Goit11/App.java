package com.Goit11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.http.HttpRequest;


public class App {
    public static void main(String[] args) throws IOException {
        HttpSimpleService server = new HttpSimpleService(5555,"/",4);
        server.start();
    }
}