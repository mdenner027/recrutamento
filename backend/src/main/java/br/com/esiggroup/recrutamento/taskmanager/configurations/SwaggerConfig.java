package br.com.esiggroup.recrutamento.taskmanager.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
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
	public Docket configDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
				.build();
	}
	
	private ApiInfo apiInfo() {
		Contact contact = new Contact("Max Denner","", "maxdenner027@hotmail.com");
		return new ApiInfoBuilder()
				.title("Sistema para gerenciamento de tarefas")
				.description("API de teste")
				.version("1.0")
				.contact(contact)
				.build();
	}
}
