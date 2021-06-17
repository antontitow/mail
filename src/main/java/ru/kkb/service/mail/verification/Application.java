package ru.kkb.service.mail.verification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

/**
 *
 * @author Marchenko_DS in 17/06/2021 - 17:51
 */
@SpringBootApplication
@ConfigurationPropertiesScan("ru.kkb.service.mail.verification.config")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
