package org.eelcorp.garage;

import org.eelcorp.garage.DBAPI.FahrzeugRepo;
import org.eelcorp.garage.DBAPI.ParkplatzRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class GarageApplication {

    // entry point
    public static void main(String[] args) {
        SpringApplication.run(GarageApplication.class, args);
    }

    // Die klassische CLI-Interaktionskomponente. Nur für Testzwecke.
    @Component
    class AppRunner implements ApplicationRunner {

        @Override
        public void run(ApplicationArguments args) throws Exception {

        }
    }
}
