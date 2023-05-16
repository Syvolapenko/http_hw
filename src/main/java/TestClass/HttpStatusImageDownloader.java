package TestClass;

import java.io.*;
import java.net.URL;


public class HttpStatusImageDownloader {

    public void downloadStatusImage(int code) {
        String host = "https://http.cat/";
        String finalUrl = host + code;
        try {
            URL url = new URL(finalUrl);
            InputStream in = new BufferedInputStream(url.openStream());
            OutputStream out = new BufferedOutputStream(new FileOutputStream("download/picture.jpeg"));

            for (int i; (i = in.read()) != -1; ) {
                out.write(i);
            }
            in.close();
            out.close();
        } catch (Exception e){
            throw new RuntimeException("There is not image for HTTP status " + code);
        }
    }
}
