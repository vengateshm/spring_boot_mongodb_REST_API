package com.vengateshm.expensetracker.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2
class SwaggerConfig {
    @Bean
    fun api(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
            .apiInfo(DEFAULT_API_INFO)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.vengateshm.expensetracker"))
            .paths(PathSelectors.ant("/**"))
            .paths(PathSelectors.any())
            .build()
            .produces(DEFAULT_PRODUCES_AND_CONSUMES)
            .consumes(DEFAULT_PRODUCES_AND_CONSUMES)
    }

    companion object {
        val DEFAULT_API_INFO = ApiInfoBuilder()
            .title("Expense Tracker")
            .description("This application is used to track everyday expenses")
            .version("1.0")
            .contact(Contact("Vengatesh M", null, "vengateshm.13@gmail.com"))
            .license("License 2.0")
            .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
            .build()

        val DEFAULT_PRODUCES_AND_CONSUMES = setOf("application/json")
    }
}

//@SwaggerDefinition
//public interface ApiDocumentationConfig {
//
//}

// URL - http://localhost:8080/v2/api-docs for seeing json response
// Swagger UI new - http://localhost:8080/swagger-ui/index.html
// Swagger UI old - http://localhost:8080/swagger-ui.html