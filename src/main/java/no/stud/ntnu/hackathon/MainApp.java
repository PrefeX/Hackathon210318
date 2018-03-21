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

        roomController.getRoomFromName("room").addTempSensor(new TempSensor("Team 1 Temp"));
        roomController.getRoomFromName("room").addTouchSensor(new TouchSensor("Team 1 Touch"));
        roomController.getRoomFromName("room").addProxSensor(new ProxSensor("Team 1 Prox"));

        while(true) {
            updateAllTempSensors(roomController.getRoomFromName("room").getTempSensors());
            updateAllTouchSensors(roomController.getRoomFromName("room").getTouchSensors());
            updateAllProxSensors(roomController.getRoomFromName("room").getProxSensors());
            System.out.println(roomController.getRoomFromName("room").getRoomStatus());
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
