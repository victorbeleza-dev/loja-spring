package br.com.example.loja.config;

import com.google.common.net.HttpHeaders;
import io.swagger.models.auth.In;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static java.util.Collections.singletonList;
import static springfox.documentation.builders.PathSelectors.regex;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    final String swaggerToken = "...";

    @Bean
    public SecurityConfiguration security() {
        return new SecurityConfiguration(null, null, null,
                null, "Bearer " + swaggerToken, ApiKeyVehicle.HEADER, "Authorization", ",");
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .globalOperationParameters(singletonList(
                        new ParameterBuilder()
                                .name("Authorization")
                                .modelRef(new ModelRef("string"))
                                .parameterType("header")
                                .required(true)
                                .hidden(true)
                                .defaultValue("Bearer " + swaggerToken)
                                .build()
                ))
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.example.loja.controller"))
//                .paths(PathSelectors.any())
                .build();
//                .useDefaultResponseMessages(false)
//                .globalResponseMessage(RequestMethod.GET, responseMessageForGET())
//                .securitySchemes(Arrays.asList(new ApiKey("Token Access", HttpHeaders.AUTHORIZATION, In.HEADER.name())))
//                .securityContexts(Arrays.asList());
    }



    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.ant("/**"))
                .build();
    }

    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope
                = new AuthorizationScope("USER", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;

        return Arrays.asList(new SecurityReference
                ("Token Access", authorizationScopes));
    }

    private ArrayList<ResponseMessage> responseMessageForGET()
    {
        return new ArrayList<ResponseMessage>() {{
            add(new ResponseMessageBuilder()
                    .code(500)
                    .message("500 message")
                    .responseModel(new ModelRef("Error"))
                    .build());
            add(new ResponseMessageBuilder()
                    .code(403)
                    .message("Forbidden!")
                    .build());
        }};
    }
}
