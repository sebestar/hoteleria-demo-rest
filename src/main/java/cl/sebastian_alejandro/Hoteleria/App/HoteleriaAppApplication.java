package cl.sebastian_alejandro.Hoteleria.App;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class HoteleriaAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(HoteleriaAppApplication.class, args);
    }

}
