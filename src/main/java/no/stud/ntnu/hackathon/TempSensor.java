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

    private JSONObject JSONObject;

    public TempSensor(String sensorName) {
        super(sensorName);
        try {
            this.JSONObject = super.getData(sensorName);
        } catch (IOException ex) {
        }
    }
    public String getTemperature(){
        
        return null;
    }
    


}
