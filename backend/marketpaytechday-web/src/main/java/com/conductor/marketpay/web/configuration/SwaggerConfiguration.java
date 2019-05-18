package com.conductor.marketpay.web.configuration;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	
	private final List<ResponseMessage> defaultMessages = Arrays.asList(
	  new ResponseMessageBuilder().code(500).message("Ocorreu um erro, por favor tente novamente.").responseModel(new ModelRef("Error")).build(),
	  new ResponseMessageBuilder().code(403).message("Acesso negado").build()
	);
	
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.any())              
          .paths(PathSelectors.any())                          
          .build()
          .globalResponseMessage(RequestMethod.GET, defaultMessages)
          .globalResponseMessage(RequestMethod.POST, defaultMessages)
          .globalResponseMessage(RequestMethod.PUT, defaultMessages)
          .globalResponseMessage(RequestMethod.DELETE, defaultMessages)
          .useDefaultResponseMessages(false);                                   
    }
}
