package dev.aman.ecommerce_product_service.Confriguations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfigurations {

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
