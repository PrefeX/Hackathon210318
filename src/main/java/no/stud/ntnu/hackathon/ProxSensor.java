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
public class ProxSensor extends Sensor{
    
    public ProxSensor(String sensorName) {
        super(sensorName);
    }
    public String getObjectPresent(){
        JSONObject devices = (JSONObject) super.jsonObject.getJSONArray("devices").get(0);
        JSONObject reported = devices.getJSONObject("reported");
        JSONObject objectPresent = reported.getJSONObject("objectPresent");
        return objectPresent.getString("state");
    }

    public boolean getStateAsBoolean() {
        if ("NOT_PRESENT" == getObjectPresent()) {
            return false;
        }
        return true;

    }
    public int getSignalStrength(){
        JSONObject devices = (JSONObject) this.JSONObject.getJSONArray("devices").get(0);
        JSONObject reported = devices.getJSONObject("reported");
        JSONObject networkStatus = reported.getJSONObject("networkStatus");
        return networkStatus.getInt("signalStrength");
    }
    public int getBatteryStatus() {
        JSONObject devices = (JSONObject) this.JSONObject.getJSONArray("devices").get(0);
        JSONObject reported = devices.getJSONObject("reported");
        JSONObject batteryStatus = reported.getJSONObject("batteryStatus");
        return batteryStatus.getInt("percentage");
    }

}
