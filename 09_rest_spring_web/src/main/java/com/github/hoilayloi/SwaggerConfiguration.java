package com.github.hoilayloi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

/*
 *
 * @author halab
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30)
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .build()
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false)
                ;
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Demo REST API",
                "Demo API Documentation.",
                "1.0",
                "",
                new Contact("halab", "https://github.com/halab4dev", ""),
                "",
                "",
                Collections.emptyList());
    }
}
