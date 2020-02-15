package rafista.intencje;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class IntencjeApplication {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication();
        app.run(IntencjeApplication.class, args);
    }
}
