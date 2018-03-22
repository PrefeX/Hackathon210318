package no.stud.ntnu.hackathon;

import java.util.HashSet;

public class Room {
    private HashSet<TempSensor> tempSensors;
    private HashSet<TouchSensor> touchSensors;
    private HashSet<ProxSensor> proxSensors;
    private String name;
    private String description;
    private boolean hasProjector;
    private boolean hasMonitor;
    private boolean hasConferenceEquipment;
    private boolean hasPhone;
    private boolean hasWhiteboard;
    private String roomPicture = "/rooms/placeholder.png";
    private String floorPlanDrawing = "/rooms/placeholder.png";

    public Room (String name, String description) {
        this.name = name;
        this.description = description;

        hasProjector = false;
        hasMonitor = false;
        hasConferenceEquipment = false;
        hasPhone = false;
        hasWhiteboard = false;

        tempSensors = new HashSet<>();
        touchSensors = new HashSet<>();
        proxSensors = new HashSet<>();
    }

    public String getName() {
        return name;
    }
    public String getRoomPicture(){
        return this.roomPicture;
    }
    public void setRoomPicture(String location){
        this.roomPicture = location;
    }
    public String getFloorPlanDrawing(){
        return this.floorPlanDrawing;
    }
    public void setFloorPlanDrawing(String location){
        this.floorPlanDrawing = location;
    }

    public String getHasProjector() {
        if(hasProjector) {
            return "&#10004;";
        } else {
            return "&#10008;";
        }
    }

    public String getHasMonitor() {
        if(hasProjector) {
            return "&#10004;";
        } else {
            return "&#10008;";
        }
    }

    public String getHasConferenceEquipment() {
        if(hasProjector) {
            return "&#10004;";
        } else {
            return "&#10008;";
        }
    }

    public String getHasPhone() {
        if(hasProjector) {
            return "&#10004;";
        } else {
            return "&#10008;";
        }
    }

    public String getHasWhiteboard() {
        if(hasProjector) {
            return "&#10004;";
        } else {
            return "&#10008;";
        }
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
    public boolean isAvailable(){
        for (ProxSensor proxSensor : proxSensors) {
            if (proxSensor.getStateAsBoolean())
                return false;
        }
        return true;
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
    public int getNumberOfAvailableChairs(){
        int result = 0;
        result = proxSensors.stream().filter((proxSensor) -> (proxSensor.getStateAsBoolean())).map((_item) -> 1).reduce(result, Integer::sum);
        return result;
    }
    public int getNumberOfChairs(){
        int result = 0;
        result = proxSensors.stream().map((_item) -> 1).reduce(result, Integer::sum);
        return result;
    }


}
