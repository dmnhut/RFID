/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.UnsupportedCharsetException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

/**
 *
 * @author Android Studio
 */
public class APITextToSpeech {
// APITextToSpeech.content = txta.getText();
// APITextToSpeech.getPostAndAddHeader();

    private static final String BASE_URL = "http://api.openfpt.vn/text2speech/v4";
    public static String API_KEY = "37730e949bbb4c8da5ee8493ffb1b096";
    public static String content = "API Text to Speech";
    private static HttpClient client = null;
    private static HttpPost post = null;
    private static HttpResponse response = null;

    public static void getPostAndAddHeader() {
        try {
            client = HttpClientBuilder.create().build();
            post = new HttpPost(BASE_URL);
            // add header
            post.setHeader("api_key", API_KEY);
            post.setHeader("speed", "0");
            post.setHeader("voice", "hatieumai");
            post.setHeader("prosody", "0");
            post.setHeader("Cache-Control", "no-cache");

            //Add content
            post.setEntity(new StringEntity(content, "UTF8"));

            //Request server
            response = client.execute(post);

            //Show respone Code
            toast("Response Code : " + response.getStatusLine().getStatusCode());

            //Download json from server
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            StringBuilder result = new StringBuilder();
            String line = "";
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            Data da = parseJson(result);
            downloadRawDataMp3(da.getAsync());
        } catch (IOException | UnsupportedCharsetException e) {
            System.out.println(" " + e.getMessage());
        }

    }

    /**
     * Parse Json from result
     *
     * @param StringBuilder
     */
    private static Data parseJson(StringBuilder result) {
        System.out.println(result);
        //Parse Json to Object with Gson 
        JsonObject json = (new JsonParser()).parse(result.toString()).getAsJsonObject();
        Data da = new Data();
        da.setAsync(json.get("async").toString());
        return da;
    }

    private static void downloadRawDataMp3(String url) {
        try {
            CloseableHttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(url.substring(1, url.length() - 1));
            HttpResponse response = client.execute(request);
            HttpEntity entity = response.getEntity();

            int responseCode = response.getStatusLine().getStatusCode();

            toast("Request Url: " + request.getURI());
            toast("Response Code: " + responseCode);

            InputStream is = entity.getContent();

            String filePath = "C:\\RFID\\sound\\audio.mp3";
            FileOutputStream fos = new FileOutputStream(new File(filePath));

            int inByte;
            while ((inByte = is.read()) != -1) {
                fos.write(inByte);
            }
            is.close();
            fos.close();
            client.close();
            toast("File Download Completed!!!");
            //Text to speech
            Speech sp = new Speech();
            sp.TextToSpeech();
        } catch (IOException | UnsupportedOperationException e) {
            System.out.println(" " + e.getMessage());
        }
    }

    private static void toast(String state) {
        System.out.println(state);
    }

}
