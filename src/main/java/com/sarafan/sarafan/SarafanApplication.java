package com.sarafan.sarafan;

import io.sentry.Sentry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SarafanApplication {

	public static void main(String[] args) {
		try {
			throw new Exception("Application started");
		} catch (Exception e) {
			Sentry.captureException(e);
		}

		SpringApplication.run(SarafanApplication.class, args);
	}

}
