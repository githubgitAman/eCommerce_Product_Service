package dev.aman.ecommerce_product_service.AuthCommons;

import dev.aman.ecommerce_product_service.DTOs.UserDTOs;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthenticatingToken {

    private RestTemplate restTemplate;
    public AuthenticatingToken(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public UserDTOs validateToken(String token) {
        //Calling validate API of user service for validating token
        UserDTOs userDtos = restTemplate.getForObject("http://localhost:4141/users/validate" + token, UserDTOs.class);
        return userDtos;
    }
}
