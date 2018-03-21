package no.stud.ntnu.hackathon;

import org.json.JSONObject;

import java.io.IOException;

public class TouchSensor extends Sensor {

    private JSONObject JSONObject;

    public TouchSensor(String sensorName) {
        super(sensorName);
        try {
            this.JSONObject = super.getData(sensorName);
        } catch (IOException ex) {
        }
    }
    public String getTouch(){

        return null;
    }
}
