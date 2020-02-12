package rafista.intencje;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IntencjeApplication {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication();
        //app.setDefaultProperties(Collections.singletonMap("server.port", "8081"));
        app.run(IntencjeApplication.class, args);

    }
}
