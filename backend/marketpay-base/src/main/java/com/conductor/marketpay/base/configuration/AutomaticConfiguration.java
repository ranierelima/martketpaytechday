package com.conductor.hackathon.base.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration("AutomaticConfiguration")
@ComponentScan("com.conductor.hackathon")
@EntityScan("com.conductor.hackathon")
@EnableJpaRepositories("com.conductor.hackathon")
public class AutomaticConfiguration {

}
