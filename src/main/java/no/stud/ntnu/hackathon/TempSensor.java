/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.stud.ntnu.hackathon;

import java.io.IOException;
import org.json.JSONObject;
import org.json.JSONString;

/**
 *
 * @author Andreas
 */
public class TempSensor extends Sensor{

    private JSONObject JSONObject;

    public TempSensor(String sensorName) {
        super(sensorName);
        try {
            this.JSONObject = super.getData();
        } catch (IOException ex) {
        }
    }
    public Double getTemperature(){
        JSONObject devices = (JSONObject) this.JSONObject.getJSONArray("devices").get(0);
        JSONObject reported = devices.getJSONObject("reported");
        JSONObject temperature = reported.getJSONObject("temperature");
        return temperature.getDouble("value");
    }
    public int getSignalStrength(){
        JSONObject devices = (JSONObject) this.JSONObject.getJSONArray("devices").get(0);
        JSONObject reported = devices.getJSONObject("reported");
        JSONObject networkStatus = reported.getJSONObject("networkStatus");
        return networkStatus.getInt("signalStrength");
    }
    


}
