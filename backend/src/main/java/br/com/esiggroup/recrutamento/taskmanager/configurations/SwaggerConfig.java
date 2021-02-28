package br.com.esiggroup.recrutamento.taskmanager.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	private static final String tagTarefas = "tarefas";
	
	private static final String tagResponsaveis = "responsaveis";
	
	@Bean
	public Docket configDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.tags(new Tag(tagTarefas, "Endpoints para o gerenciamento de tarefas"))
				.tags(new Tag(tagResponsaveis, "Endpoints para o gerenciamento de responsáveis"))
				.apiInfo(apiInfo())
				.useDefaultResponseMessages(false)
				.select()
				.apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
				.build()
				.directModelSubstitute(Object.class, Void.class);
	}
	
	private ApiInfo apiInfo() {
		Contact contact = new Contact("Max Denner","https://www.linkedin.com/in/max-denner-t-da-silva-a72bb5165/", "maxdenner027@hotmail.com");
		return new ApiInfoBuilder()
				.title("Sistema para gerenciamento de tarefas")
				.description("API de teste")
				.version("1.0")
				.contact(contact)
				.build();
	}
}
