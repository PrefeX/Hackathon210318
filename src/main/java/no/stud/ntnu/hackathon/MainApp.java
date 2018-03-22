package no.stud.ntnu.hackathon;

import org.springframework.boot.SpringApplication;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainApp {

    private ArrayList<Sensor> sensors;
    public static RoomController roomController;

    public MainApp(String[] args) {

        SpringApplication.run(HackathonApplication.class, args);

        roomController = new RoomController();
        sensors = new ArrayList<>();

        roomController.addRoom("room", "Best room available");
        roomController.addRoom("room2", "Best room available 2");
        roomController.addTempSensorToRoom("room", "Team 1 Temp");
        roomController.addTempSensorToRoom("room", "Team 1 Temp 2");
        roomController.addTouchSensorToRoom("room", "Team 1 Touch");
        roomController.addProxSensorToRoom("room", "Team 1 Prox");
        roomController.addProxSensorToRoom("room", "Team 2 Prox");
        roomController.addProxSensorToRoom("room2", "Team 1 Prox 2");
        roomController.addProxSensorToRoom("room2", "Team 3 Prox");

        while(true) {
            updateAllTempSensors(roomController.getRoomFromName("room").getTempSensors());
            updateAllTouchSensors(roomController.getRoomFromName("room").getTouchSensors());
            updateAllProxSensors(roomController.getRoomFromName("room").getProxSensors());
            System.out.println(roomController.getRoomFromName("room").getRoomStatus());
            updateAllProxSensors(roomController.getRoomFromName("room2").getProxSensors());
            System.out.println(roomController.getRoomFromName("room2").getRoomStatus());
            for(Room r : roomController.getRooms()) {
                for(TouchSensor ts : r.getTouchSensors()) {
                    if(ts.isActionRequired()) {
                        roomController.getServiceAlerts().add(r);
                    }
                }
            }
        }
    }

    public static void updateAllTempSensors(HashSet<TempSensor> sensors) {
        for(Sensor sensor : sensors) {
            sensor.updateData();
        }
    }

    public static void updateAllTouchSensors(HashSet<TouchSensor> sensors) {
        for(Sensor sensor : sensors) {
            sensor.updateData();
        }
    }

    public static void updateAllProxSensors(HashSet<ProxSensor> sensors) {
        for(Sensor sensor : sensors) {
            sensor.updateData();
        }
    }

    public static void main(String[] args) {
        MainApp mainApp = new MainApp(args);
    }
}
