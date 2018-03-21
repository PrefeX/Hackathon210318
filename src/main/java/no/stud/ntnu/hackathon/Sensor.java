/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.stud.ntnu.hackathon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;

/**
 *
 * @author Andreas
 */
public class Sensor extends Thread {
    private final String serviceAccountKey = "banmjq324te000b24ubg";
    private final String serviceAccountSecret = "03ac12bfc30047d5b7bba0cbb4d36c1f";
    private final String projectId = "baj44uni50gg00dhk030";
    private final String apiUrlBase = "https://api.disruptive-technologies.com/v2beta1";
    private final String apiDeviceUrl = apiUrlBase + "/projects/" + projectId + "/devices";
    private final String codeExampleSensorDisplayName;
    private String urlString;
    
    public Sensor(String sensorName) {
        this.codeExampleSensorDisplayName = sensorName;
        try {
            urlString = (apiDeviceUrl + "?label_filters=" + URLEncoder.encode("name=" + codeExampleSensorDisplayName, "UTF-8"));
        } catch (UnsupportedEncodingException ex) {
        }
    }
    public JSONObject getData() throws MalformedURLException, IOException{
        URL url = new URL(this.urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        String userpass = serviceAccountKey + ":" + serviceAccountSecret;
        String basicAuth = "Basic " + javax.xml.bind.DatatypeConverter.printBase64Binary(userpass.getBytes());
        conn.setRequestProperty("Authorization", basicAuth);
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");
        int responseCode = conn.getResponseCode();
        if (responseCode != HttpURLConnection.HTTP_OK) {
            throw new RuntimeException("Failed : HTTP error code : " + responseCode);
        }
        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
        String response = br.readLine();
        conn.disconnect();
        return new JSONObject(response);
    }
    //TODO: method for streaming sensordata
}
    