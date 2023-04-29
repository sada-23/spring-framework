package com.company;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.output.MigrateResult;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
public class CinemaLabApplication {

	public static void main(String[] args) {
		SpringApplication.run(CinemaLabApplication.class, args);}


	/*
	 * · When "application.properties" -> spring.flyway.enabled=false :
	 *  1. Flyway is looking for a data source, and it doesn't know where is the data source. We should manually tell Flyway where is the data source.
	 *  2.  We need first, an entity to be created, then a flyway to do migration. Since our table is not ready, we need to tell Flyway our data source.
	 */
	@Bean
	public MigrateResult migrateResult(DataSource dataSource){
		return Flyway.configure().baselineOnMigrate(true).dataSource(dataSource).load().migrate();
	}
}
