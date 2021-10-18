package phoenix.api.utils;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.http.HttpHeaders;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Objects;
import java.util.Scanner;

public class Request {

    public final static String defaultUserAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/94.0.4606.81 Safari/537.36";

    public static JsonElement postRequest(String url, JsonObject data) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .setHeader(HttpHeaders.CONTENT_TYPE, "application/json")
            .setHeader(HttpHeaders.USER_AGENT, defaultUserAgent)
            .setHeader(HttpHeaders.ACCEPT, "*/*")
            .POST(HttpRequest.BodyPublishers.ofString(data.toString()))
            .build();

        try {
            return JsonParser.parseString(client.send(request, HttpResponse.BodyHandlers.ofString()).body());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static JsonElement postRequest(String url) {
        return postRequest(url, new JsonObject());
    }

    public static JsonElement getRequest(String url) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .setHeader(HttpHeaders.USER_AGENT, defaultUserAgent)
            .setHeader(HttpHeaders.ACCEPT, "*/*")
            .uri(URI.create(url))
            .GET()
            .build();

        try {
            return JsonParser.parseString(client.send(request, HttpResponse.BodyHandlers.ofString()).body());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

}
