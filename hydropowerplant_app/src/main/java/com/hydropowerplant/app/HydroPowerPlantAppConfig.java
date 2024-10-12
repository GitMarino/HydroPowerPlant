package com.hydropowerplant.app;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EntityScan("com.hydropowerplant.water-level.entity")
@EnableJpaRepositories("com.hydropowerplant.water-level.repository")
@Configuration
@ComponentScan(basePackages = "com.hydropowerplant.water-level.manager")
@PropertySources({@PropertySource("classpath:database.properties"), @PropertySource("classpath:server.properties")})
/*@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableBatchProcessing*/
public class HydroPowerPlantAppConfig {

}