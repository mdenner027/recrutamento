package br.com.esiggroup.recrutamento.taskmanager.configurations;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;
import com.google.common.collect.Lists;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	private static final String AUTHORIZATION_HEADER = "Authorization";
	
	private static final String tagLogin = "login e cadastro";
	
	private static final String tagTarefas = "tarefas";
	
	private static final String tagResponsaveis = "responsaveis";
	
	@Bean
	public Docket configDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.tags(new Tag(tagTarefas, "Endpoints para o gerenciamento de tarefas"))
				.tags(new Tag(tagResponsaveis, "Endpoints para o gerenciamento de responsáveis"))
				.tags(new Tag(tagLogin, "Endpoints para login e cadastro de novos usuários"))
				.apiInfo(apiInfo())
				.securityContexts(Lists.newArrayList(securityContent()))
				.securitySchemes(Lists.newArrayList(new ApiKey("JWT", AUTHORIZATION_HEADER, "header")))
				.useDefaultResponseMessages(false)
				.select()
				.apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
				.build()
				.directModelSubstitute(Object.class, Void.class);
	}
	
	
	private SecurityContext securityContent() {
        return SecurityContext.builder()
            .securityReferences(defaultAuth())
            .forPaths(PathSelectors.regex("/admin.*"))
            .build();
    }
	
	private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Lists.newArrayList(new SecurityReference("JWT", authorizationScopes));
    }
	
	private ApiInfo apiInfo() {
		Contact contact = new Contact("Max Denner","https://www.linkedin.com/in/max-denner-t-da-silva-a72bb5165/", "maxdenner027@hotmail.com");
		return new ApiInfoBuilder()
				.title("Sistema para gerenciamento de tarefas")
				.description("O task-manager trata-se de uma API desenvolvida como "
						+ "atividade técnica para o processo seletivo referente à vaga de "
						+ "desenvolvedor backend Java, da Esig Group."
						+ "\nDe forma simplificada, a presente API permite o cadastramento e gerenciamento de tarefas e "
						+ "de responsáveis que estão ligados às tarefas.")
				.version("1.0")
				.contact(contact)
				.build();
	}
}
