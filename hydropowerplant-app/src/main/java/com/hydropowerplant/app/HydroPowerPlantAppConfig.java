package com.hydropowerplant.app;

import com.hydropowerplant.waterlevel.businesslayer.object.property.MailProperties;
import com.hydropowerplant.waterlevel.businesslayer.object.property.SmsProperties;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan("com.hydropowerplant.waterlevel.entity")
@EnableJpaRepositories("com.hydropowerplant.waterlevel.dataaccesslayer.repository")
@ComponentScan(basePackages = "com.hydropowerplant.waterlevel")
@PropertySources({
        @PropertySource("classpath:database.properties"),
        @PropertySource("classpath:mail.properties"),
        @PropertySource("classpath:server.properties")
})
@EnableConfigurationProperties({MailProperties.class, SmsProperties.class})
public class HydroPowerPlantAppConfig {

}