package no.stud.ntnu.hackathon;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.time.Instant;

public class TouchSensor extends Sensor {

    private java.util.Date lastTouch = null;
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
        String input = result;
        Instant instant = Instant.parse(input);
        java.util.Date date = java.util.Date.from(instant);
        
        if (lastTouch == null) {

        } else {
            if (!lastTouch.equals(date)) {
                actionRequired = true;
                lastTouch = date;
            }
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

    public void setActionDone() {
        actionRequired = false;
    }

    public boolean isActionRequired() {
        return actionRequired;
    }

    public int getBatteryStatus() {
        JSONObject devices = (JSONObject) super.jsonObject.getJSONArray("devices").get(0);
        JSONObject reported = devices.getJSONObject("reported");
        JSONObject batteryStatus = reported.getJSONObject("batteryStatus");
        return batteryStatus.getInt("percentage");
    }

}
