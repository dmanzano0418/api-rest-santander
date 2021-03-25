/**
 * 
 */
package com.mx.santander.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author dmanzano
 *
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.mx.santander.repository")
public class JpaConfig {

	public JpaConfig() {}

}
