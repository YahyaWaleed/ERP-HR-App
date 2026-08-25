package com.yahya.erphrapp.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;

// setting up the OpenApi documentation
public class OpenApiConfig {

    @Bean
    public OpenAPI erpHrOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("ERP HR & Payroll API")
                        .version("1.0")
                        .description("API for managing employees, payroll, loans, leaves, and attendance"));
    }
}
