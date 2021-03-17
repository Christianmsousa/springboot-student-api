package com.christian.modelonovo.swagger;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.RequestHandler;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
public class SwaggerConfig {

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2).select()
        .apis(RequestHandlerSelectors.basePackage("com.christian.modelonovo.interfaces.controller"))
        .paths(regex("api/v1.*")).build().apiInfo(metaInfo());
  }

  private ApiInfo metaInfo() {

    ApiInfo apiInfo = new ApiInfo(
            "API Escola",
            "API para estudar conteúdos aprendidos na sensedia",
            "1.0",
            "Sobre",
            new Contact("Christian Marçal", "https://github.com/christianmsousa", "christian.sousa@sensedia.com"),
            "Documentação Swagger",
            "https://swagger.io/",
            new ArrayList<VendorExtension>());

    return apiInfo;
  }
}
