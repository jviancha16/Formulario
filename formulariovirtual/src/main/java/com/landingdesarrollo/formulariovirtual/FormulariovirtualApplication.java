package com.landingdesarrollo.formulariovirtual;

import com.landingdesarrollo.formulariovirtual.entity.Contact;
import com.landingdesarrollo.formulariovirtual.repository.ContactRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FormulariovirtualApplication {

	public static void main(String[] args) {
		SpringApplication.run(FormulariovirtualApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(ContactRepository contactRepository) {
		return args -> {
				List<Contact> contacts = Arrays.asList(
						new Contact("Carlos", "carlos@gmail.com", "900000210","Virtual", "Bogota", "Global Vida", "1234", true, LocalDateTime.now()),
						new Contact("Juan", "juan@gmail.com", "901201123", "Presencial", "Cali", "Global Vida", "5678", true, LocalDateTime.now()),
						new Contact("Sofia", "sofia@gmail.com", "801203221", "Virtual", "Medellin", "Global Education", "91012", true, LocalDateTime.now()),
						new Contact("Jose", "jose@gmail.com", "901112321", "Presencial", "Bogota", "Global Vida", "12345", true, LocalDateTime.now()),
						new Contact("John", "john@gmail.com", "901999032", "Presencial", "Bogota", "Global Vida", "12345", true, LocalDateTime.now())
				);
				contactRepository.saveAll(contacts);

		};
	}
}
