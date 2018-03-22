package no.stud.ntnu.hackathon;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

public class TouchSensor extends Sensor {

    private String lastTouch;
    private boolean actionRequired;

    public TouchSensor(String sensorName) {
        super(sensorName);
    }

    public String getTouch() {
        String result = "";
        JSONArray devices = super.jsonObject.getJSONArray("devices");
        JSONObject device = devices.getJSONObject(0);
        JSONObject reported = device.getJSONObject("reported");
        JSONObject touch = reported.getJSONObject("touch");
        String updateTime = touch.getString("updateTime");
        super.setUpdateTime(updateTime);
        result = updateTime;
        if (!lastTouch.equals(result)) {
            actionRequired = true;
            lastTouch = result;
        }
        //return json.toString();
        return result;
    }

    public int getSignalStrength() {
        JSONObject devices = (JSONObject) super.jsonObject.getJSONArray("devices").get(0);
        JSONObject reported = devices.getJSONObject("reported");
        JSONObject networkStatus = reported.getJSONObject("networkStatus");
        return networkStatus.getInt("signalStrength");
    }
    public void setActionDone(){
        actionRequired = false;
    }

    public int getBatteryStatus() {
        JSONObject devices = (JSONObject) super.jsonObject.getJSONArray("devices").get(0);
        JSONObject reported = devices.getJSONObject("reported");
        JSONObject batteryStatus = reported.getJSONObject("batteryStatus");
        return batteryStatus.getInt("percentage");
    }

}
