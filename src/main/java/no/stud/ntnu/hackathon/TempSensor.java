/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.stud.ntnu.hackathon;

import java.io.IOException;
import org.json.JSONObject;

/**
 *
 * @author Andreas
 */
public class TempSensor extends Sensor{

    public TempSensor(String sensorName) {
        super(sensorName);
    }
    public Double getTemperature(){
        JSONObject devices = (JSONObject) super.jsonObject.getJSONArray("devices").get(0);
        JSONObject reported = devices.getJSONObject("reported");
        JSONObject temperature = reported.getJSONObject("temperature");
        return temperature.getDouble("value");
    }
    public int getSignalStrength(){
        JSONObject devices = (JSONObject) super.jsonObject.getJSONArray("devices").get(0);
        JSONObject reported = devices.getJSONObject("reported");
        JSONObject networkStatus = reported.getJSONObject("networkStatus");
        return networkStatus.getInt("signalStrength");
    }
    public int getBatteryStatus() {
        JSONObject devices = (JSONObject) super.jsonObject.getJSONArray("devices").get(0);
        JSONObject reported = devices.getJSONObject("reported");
        JSONObject batteryStatus = reported.getJSONObject("batteryStatus");
        return batteryStatus.getInt("percentage");
    }
    
    
    


}
