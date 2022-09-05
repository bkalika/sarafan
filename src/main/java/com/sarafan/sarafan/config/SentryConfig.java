package com.sarafan.sarafan.config;

import io.sentry.spring.EnableSentry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author @bkalika
 * Created on 18.08.2022 10:38 AM
 */

@EnableSentry(dsn = "https://3c9e1cf2073d49e0b4b2629dba65c3c9@o1365396.ingest.sentry.io/6661958")
@Configuration
public class SentryConfig {
}
