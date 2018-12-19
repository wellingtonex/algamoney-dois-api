package com.algaworks.algamoney.dois.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AlgamoneyDoisApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlgamoneyDoisApiApplication.class, args);
	}
	
//	@Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurerAdapter() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**").allowedOrigins("http://localhost:8000");
//            }
//        };
//    }
}
