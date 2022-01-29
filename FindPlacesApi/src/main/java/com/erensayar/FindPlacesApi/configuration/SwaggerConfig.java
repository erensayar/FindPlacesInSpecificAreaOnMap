package com.erensayar.FindPlacesApi.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.erensayar.FindPlaces"))
                .paths(PathSelectors.regex("/api.*"))
                .build().apiInfo(findPlacesApiInfo());
    }

    private ApiInfo findPlacesApiInfo() {
        return new ApiInfoBuilder()
                .title("Find Places Web Api")
                .description("API Doc")
                .contact(new Contact("Eren Sayar", "github.com/erensayar", "erensayar@yandex.com"))
                .license("GENERAL PUBLIC LICENSE v3.0")
                .licenseUrl("www.gnu.org")
                .version("1.0.0")
                .build();
    }
}
