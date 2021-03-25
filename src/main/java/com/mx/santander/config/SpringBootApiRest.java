/**
 * 
 */
package com.mx.santander.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;

/**
 * @author dmanzano
 *
 */
@SpringBootApplication
@ComponentScan("com.mx.santander")
@EntityScan("com.mx.santander.model")
@PropertySource("classpath:/application.properties")
public class SpringBootApiRest extends SpringBootServletInitializer {
	
	@Bean
	public RestTemplate getresttemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringBootApiRest.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    	return application.sources(SpringBootApiRest.class);
    }
 
}
