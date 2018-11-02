package com.nexity.wgl.ms.fiches.location.configuration;

import static com.google.common.collect.Lists.newArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ClassUtils;

import com.nexity.wgl.ms.fiches.location.FichesLocationApplication;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage(ClassUtils.getPackageName(FichesLocationApplication.class)))
				.build().apiInfo(metaData());
	}

	private ApiInfo metaData() {
		final ApiInfo apiInfo = new ApiInfo("Weasy Gestion Locative - fiches location", "",
				getClass().getPackage().getImplementationVersion(), "", new Contact("", "", ""), "Nexity", "",
				newArrayList());
		return apiInfo;
	}
}