package no.stud.ntnu.hackathon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

@Configuration
@ComponentScan
@SpringBootApplication
public class HackathonApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(HackathonApplication.class);
    }

    public static void main(String[] args) {

        TempSensor tempSensor = new TempSensor("Team 1 Temp");
        //System.out.println(tempSensor.getTemperature());

        //SpringApplication.run(HackathonApplication.class, args);
    }
}
