package com.conductor.marketpay.base.configuration;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration("AutomaticConfiguration")
@ComponentScan("com.conductor.marketpay")
@EntityScan("com.conductor.marketpay")
@EnableJpaRepositories("com.conductor.marketpay")
@EnableBatchProcessing
public class AutomaticConfiguration {

}
