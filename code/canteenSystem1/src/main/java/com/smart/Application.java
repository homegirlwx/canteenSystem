package com.smart;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;

//@Configuration
//@ComponentScan
//@EnableAutoConfiguration
@SpringBootApplication
@EnableTransactionManagement
public class Application  extends SpringBootServletInitializer implements WebApplicationInitializer {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }


    @Bean
    public PlatformTransactionManager txManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }


    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {
           // Quote quote = restTemplate.getForObject(
                   // "http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
            //log.info(quote.toString());

            //String postUrl = "";
            //ResponseEntity<String> rst = restTemplate.postForEntity(postUrl, request, String.class);

            //log.info("Post File to Server:"+rst);
        };
    }


}

