package sample.util;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HTTPHandler {

    public static String post(String route, String jsonBody) throws IOException {
        URL url = new URL("http://genetv.net:34430" + route);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Accept", "application/json");
        OutputStreamWriter osw = new OutputStreamWriter(connection.getOutputStream());
        osw.write(jsonBody);
        osw.flush();
        osw.close();
        return connection.getResponseCode() + "";
    }
}
