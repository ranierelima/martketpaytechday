package com.conductor.marketpay.web.configuration;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.conductor.marketpay.base.model.SFTPFileValidation;
import com.conductor.marketpay.base.model.dto.ValidationFileSFTPDTO;
import com.conductor.marketpay.web.batch.listerner.JobCompletionNotificationListener;
import com.conductor.marketpay.web.batch.processor.ValidationFilesProcessor;
import com.conductor.marketpay.web.batch.reader.ValidationFilesReader;
import com.conductor.marketpay.web.batch.writer.ValidationFilesWriter;

@Configuration
public class BatchConfiguration {

	private JobBuilderFactory jobBuilder;
	private StepBuilderFactory stepBuilder;
	
	@Autowired
	public BatchConfiguration (JobBuilderFactory jobBuilder, StepBuilderFactory stepBuilder) {
		this.jobBuilder = jobBuilder;
		this.stepBuilder = stepBuilder;
	}
	
	@Bean
    public ValidationFilesReader reader() {
        return new ValidationFilesReader();
    }

    @Bean
    public ValidationFilesProcessor processor() {
        return new ValidationFilesProcessor();
    }

    @Bean
    public ValidationFilesWriter writer() {
        return new ValidationFilesWriter();
    }
    
    @Bean
    public Job validationFiles(JobCompletionNotificationListener listener, Step step1) {
        return this.jobBuilder.get("validationFiles")
            .incrementer(new RunIdIncrementer())
            .listener(listener)
            .flow(step1)
            .end()
            .build();
    }

    @Bean
    public Step validacoesSFTP() {
        return stepBuilder.get("validacoesSFTP")
            .<SFTPFileValidation, ValidationFileSFTPDTO> chunk(10)
            .reader(reader())
            .processor(processor())
            .writer(writer())
            .build();
    }
}
