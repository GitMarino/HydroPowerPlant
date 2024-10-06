package com.hydropowerplant.app;

import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@PropertySources({@PropertySource("classpath:database.properties"), @PropertySource("classpath:server.properties")})
public class HydroPowerPlantAppConfig {

}