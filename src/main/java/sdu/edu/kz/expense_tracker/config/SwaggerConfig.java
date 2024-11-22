package sdu.edu.kz.expense_tracker.config;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Expense Tracker RestAPI",
                version = "version 1.0",
                contact = @Contact(
                        name = "Meiirzhan Muratbekuly",
                        email = "230103036@sdu.edu.kz",
                        url = "https://t.me/channel_smilexah"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://www.apache.org/licenses/LICENSE-2.0"
                ),
                termsOfService = "https://sdu.edu.kz/language/en/terms-and-conditions/",
                description = "Expense Tracker RESTFul API Documentation"
        ),
        externalDocs = @ExternalDocumentation(
                description = "Expense Tracker RESTFul API Documentation for Developers",
                url = "https://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config"
        )
)
public class SwaggerConfig {
}
