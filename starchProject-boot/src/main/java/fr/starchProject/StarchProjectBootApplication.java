package fr.starchProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import fr.starchProject.config.FileStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({
    FileStorageProperties.class
})
public class StarchProjectBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(StarchProjectBootApplication.class, args);
	}

}
