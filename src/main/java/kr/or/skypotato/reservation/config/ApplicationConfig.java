package kr.or.skypotato.reservation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource({"classpath:application.properties"})
@ComponentScan(basePackages = { "kr.or.skypotato.reservation.dao",  "kr.or.skypotato.reservation.service"})
@Import({ DBConfig.class })
public class ApplicationConfig {

}
