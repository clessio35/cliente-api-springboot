package com.ctech.client_api.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

	@Bean
	Queue clienteQueue() {
		return new Queue("clienteQueue", false);
	}
}
