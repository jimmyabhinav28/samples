package dev.abhinav.spring.samples.restEndpointSample.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration extends WebMvcConfigurationSupport {
	/**
	 * After the Docket bean is defined, its select() method returns an instance of
	 * ApiSelectorBuilder, which provides a way to control the endpoints exposed by
	 * Swagger.
	 * 
	 * @return
	 */
	@Bean
	public Docket productApi() {
//		return new Docket(DocumentationType.SWAGGER_2).select()
//				.apis(RequestHandlerSelectors.basePackage("dev.abhinav.spring.samples.restEndpointSample.controllers"))
//				.paths(regex("/product.*")).build().apiInfo(metaData());
		
		//we had configured to expose only controllers in package 
		//dev.abhinav.spring.samples.restEndpointSample.controllers
		//to be exposed by swagger in the code commented above
		
		//below we have instructed that all request handlers must be exposed by 
		//swagger
		//also the paths selector tells that api's corresponding to which path must be
		//exposed by Swagger. Below we have instructed swagger to select all paths
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build()
				.apiInfo(metaData());
	}

	//add metadata about the apis here
	private ApiInfo metaData() {
		return new ApiInfoBuilder().title("Spring Boot REST API")
				.description("\"Spring Boot REST API for Online Store\"").version("1.0.0")
				.license("Apache License Version 2.0").licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
				.contact(
						new Contact("John Thompson", "https://springframework.guru/about/", "john@springfrmework.guru"))
				.build();
	}

//	@Override
//	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
//		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
//
//		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
//	}
}
