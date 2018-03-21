package no.stud.ntnu.hackathon;

import java.util.ArrayList;

public class RoomController {
    private ArrayList<Room> rooms;

    public RoomController() {
        rooms = new ArrayList<>();
    }
    public void addRoom(String name, String description) {
        rooms.add(new Room(name, description));
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

    public Room getRoomFromName(String name) {
        for(Room room : rooms) {
            if (name.equals(room.getName())) {
                return room;
            }
        }
        return null;
    }
}
