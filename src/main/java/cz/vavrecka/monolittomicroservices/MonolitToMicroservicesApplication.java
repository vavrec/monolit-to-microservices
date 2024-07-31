package cz.vavrecka.monolittomicroservices;

import cz.vavrecka.shared.exception.handler.controller.ControllerExceptionHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@ControllerExceptionHandler
@SpringBootApplication
public class MonolitToMicroservicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(MonolitToMicroservicesApplication.class, args);
    }

}
