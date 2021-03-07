package com.pe.relari.employee.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * <b>Class:</b> SwaggerConfiguration.</br>
 * @author Renzo Lavado Rivas.
 * @version 1.0.0
 */

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(apiInfo())
        .select()
        .paths(PathSelectors.any())
        .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
        .build()
        .useDefaultResponseMessages(false);
  }

  private ApiInfo apiInfo() {
    return new ApiInfo("Spring boot Restfull", "Api", "V 1.0.0", "Terms of controller",
        new Contact("Renzo Daniel Lavado Rivas", "https://github.com/Relari",
            "renzolavador@gmail.com"),
        "License of Spring boot Restfull", "Spring boot license URL", Collections.emptyList());
  }
}
