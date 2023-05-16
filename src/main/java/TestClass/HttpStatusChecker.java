package TestClass;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStatusChecker {
    private String url;

    public HttpStatusChecker(String url) {
        this.url = url;
    }

    public String getStatusImage(int code) {
        String finalUrl = url + code;
        int responseCode;
        try {
            URL obj = new URL(finalUrl);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            responseCode = con.getResponseCode();
        } catch (Exception e) {
            throw new RuntimeException("Invalid host");
        }
        if (responseCode == 200) {
            return finalUrl;
        } else {
            finalUrl = String.valueOf(responseCode);
        }
        return finalUrl;
    }
}