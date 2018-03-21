package no.stud.ntnu.hackathon;

import java.util.HashSet;

public class Room {
    private HashSet<TempSensor> tempSensors;
    private HashSet<TouchSensor> touchSensors;
    private HashSet<ProxSensor> proxSensors;
    private String name;

    public Room (String name, String description) {
        this.name = name;
        tempSensors = new HashSet<>();
        touchSensors = new HashSet<>();
        proxSensors = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void addTempSensor(TempSensor sensor) {
        tempSensors.add(sensor);
    }
    public void addTouchSensor(TouchSensor sensor) {
        touchSensors.add(sensor);
    }
    public void addProxSensor(ProxSensor sensor) {
        proxSensors.add(sensor);
    }

    public HashSet<TempSensor> getTempSensors() {
        return tempSensors;
    }

    public HashSet<TouchSensor> getTouchSensors() {
        return touchSensors;
    }

    public HashSet<ProxSensor> getProxSensors() {
        return proxSensors;
    }

    public String getRoomStatus() {
        String result = "";
        for(TempSensor temps: tempSensors) {
            result += "temperature on " + temps.getSensorName() + ": " + temps.getTemperature() + "\n";
        }
        for(TouchSensor touchs: touchSensors) {
            result += "latest update on " + touchs.getSensorName() + ": " + touchs.getTouch() + "\n";
        }
        for(ProxSensor proxs: proxSensors) {
            result += "status on " + proxs.getSensorName() + ": " + proxs.getObjectPresent() + "\n";
        }
        return result;
    }
}
