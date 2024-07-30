package cz.vavrecka.monolittomicroservices;

import org.springframework.boot.SpringApplication;

public class TestMonolitToMicroservicesApplication {

    public static void main(String[] args) {
        SpringApplication.from(MonolitToMicroservicesApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
