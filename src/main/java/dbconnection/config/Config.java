package dbconnection.config;

import dbconnection.client.ContactClient;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration to decline beans, which are not marked by annotations
 */
@Configuration
@ComponentScan("dbconnection")
public class Config {

    @Bean
    public ContactClient contactClient(){
        return Feign.builder()
                .contract(new SpringMvcContract())
                .decoder(new JacksonDecoder())
                .encoder(new JacksonEncoder())
                .target(ContactClient.class, "http://localhost:8080");
    }

}
