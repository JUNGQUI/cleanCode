package com.jklee.cleancode.config;

import java.sql.SQLException;
import org.h2.tools.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("h2_local")
@Configuration
public class CustomH2Configuration {

	@Bean
	public Server h2TcpServer() throws SQLException {
		return Server.createTcpServer().start();
	}
}
