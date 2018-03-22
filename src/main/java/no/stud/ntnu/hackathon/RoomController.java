package no.stud.ntnu.hackathon;

import java.util.ArrayList;

public class RoomController {
    private boolean actionRequired = false;
    private ArrayList<Room> rooms;
    private ArrayList<Sensor> serviceAlerts;

    public RoomController() {
        serviceAlerts = new ArrayList<>();
        rooms = new ArrayList<>();
    }
    public void addRoom(String name, String description) {
        rooms.add(new Room(name, description));
    }
    public boolean checkForActionRequired(){
        for (Room room : rooms) {
            for (TouchSensor touchSensor : room.getTouchSensors()) {
                if (touchSensor.isActionRequired())
                    return true;
            }
        }
        return false;
    }

    public ArrayList<Sensor> getServiceAlerts () {
        return serviceAlerts;
    }
    
    public void addTempSensorToRoom(String roomName, String sensorName){
        getRoomFromName(roomName).addTempSensor(new TempSensor(sensorName));
    }
    public void addProxSensorToRoom(String roomName, String sensorName){
        getRoomFromName(roomName).addProxSensor(new ProxSensor(sensorName));
    }
    public void addTouchSensorToRoom(String roomName, String sensorName){
        getRoomFromName(roomName).addTouchSensor(new TouchSensor(sensorName));
    }
    public ArrayList<Room> getAvailableRooms(){
        ArrayList<Room> availableRooms = new ArrayList<>();
        this.rooms.stream().filter((room) -> (room.isAvailable())).forEachOrdered((room) -> {
            availableRooms.add(room);
        });
        return availableRooms;
    }
    public ArrayList<Room> getUnavailableRooms(){
        ArrayList<Room> unavailableRooms = new ArrayList<>();
        this.rooms.stream().filter((room) -> (!room.isAvailable())).forEachOrdered((room) -> {
            unavailableRooms.add(room);
        });
        return unavailableRooms;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public Room getRoomFromName(String name) {
        for(Room room : rooms) {
            if (name.equals(room.getName())) {
                return room;
            }
        }
        return null;
    }
}
