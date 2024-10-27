package com.hydropowerplant.app;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan("com.hydropowerplant.waterlevel.database")
@EnableJpaRepositories("com.hydropowerplant.waterlevel.dao")
@ComponentScan(basePackages = "com.hydropowerplant.waterlevel.businesslogic")
@PropertySources({@PropertySource("classpath:database.properties"), @PropertySource("classpath:server.properties")})
/*@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableBatchProcessing*/
public class HydroPowerPlantAppConfig {

}