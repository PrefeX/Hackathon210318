/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.getsensordata;

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
public class TempSensor {

    private String serviceAccountKey = "banmjq324te000b24ubg";
    private String serviceAccountSecret = "03ac12bfc30047d5b7bba0cbb4d36c1f";
    private String projectId = "baj44uni50gg00dhk030";
    private String apiUrlBase = "https://api.disruptive-technologies.com/v2beta1";
    private String apiDeviceUrl = apiUrlBase + "/projects/" + projectId + "/devices";
    private String codeExampleSensorDisplayName = "Team 1 Temp";
    private JSONObject JSONObject;

    public TempSensor() {

        try {
            this.JSONObject = getJSONObject(update(apiDeviceUrl + "?label_filters=" + URLEncoder.encode("name=" + codeExampleSensorDisplayName, "UTF-8"));
        } catch (Exception ex) {
        }

    }

    private String update(String urlString) throws MalformedURLException, IOException {
        URL url = new URL(urlString);
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
        return response;
    }

    public JSONObject getJSONObject(String string) {
        return new JSONObject(string);
    }

    public String getSensorType() {

    }
}
