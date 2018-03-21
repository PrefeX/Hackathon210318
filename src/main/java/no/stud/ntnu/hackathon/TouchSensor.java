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
}
