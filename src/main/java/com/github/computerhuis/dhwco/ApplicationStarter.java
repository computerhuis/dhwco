package com.github.computerhuis.dhwco;

import lombok.val;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationStarter {

    private final static String DEFAULT_PROFILE = "otap";

    public static void main(final String[] args) {
        val application = new SpringApplication(ApplicationStarter.class);
        application.setAdditionalProfiles(DEFAULT_PROFILE);
        application.run(args);
    }
}
