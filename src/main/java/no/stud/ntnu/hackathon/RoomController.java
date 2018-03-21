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

    public Room getRoomFromName(String name) {
        for(Room room : rooms) {
            if (name.equals(room.getName())) {
                return room;
            }
        }
        return null;
    }
}
