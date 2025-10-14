package tony.demo;

import tony.demo.repository.H2SessionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class H2DemoApplication {

    private static final Logger log = LoggerFactory.getLogger(H2DemoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(H2DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(H2SessionRepository h2SessionRepository) {
        return (args) -> {
            log.info("--- H2 Sessions Information ---");
            h2SessionRepository.findAll().forEach(session -> log.info(session.toString()));

            // Find sessions for a specific user, in this case 'SA' (the default user).
            // This will find the session created by this running Spring Boot application.
            log.info("--- Find session by user name 'SA' ---");
            h2SessionRepository.findByUserName("SA").forEach(session -> log.info(session.toString()));
        };
    }
}
