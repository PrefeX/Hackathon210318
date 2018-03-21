package no.stud.ntnu.hackathon;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

public class TouchSensor extends Sensor {

    private JSONObject json;

    public TouchSensor(String sensorName) {
        super(sensorName);
        try {
            this.json = super.getData();
            
        } catch (IOException ex) {
        }
    }
    public String getTouch(){
        String result = "";
        JSONArray devices = json.getJSONArray("devices");
        JSONObject device = devices.getJSONObject(0);
        JSONObject reported = device.getJSONObject("reported");
        JSONObject touch = reported.getJSONObject("touch");
        String updateTime = touch.getString("updateTime");
        result = updateTime;
        //return json.toString();
        return result;
    }
    public int getSignalStrength(){
        JSONObject devices = (JSONObject) this.json.getJSONArray("devices").get(0);
        JSONObject reported = devices.getJSONObject("reported");
        JSONObject networkStatus = reported.getJSONObject("networkStatus");
        return networkStatus.getInt("signalStrength");
    }
    public int getBatteryStatus() {
        JSONObject devices = (JSONObject) this.json.getJSONArray("devices").get(0);
        JSONObject reported = devices.getJSONObject("reported");
        JSONObject batteryStatus = reported.getJSONObject("batteryStatus");
        return batteryStatus.getInt("percentage");
    }
    
}
