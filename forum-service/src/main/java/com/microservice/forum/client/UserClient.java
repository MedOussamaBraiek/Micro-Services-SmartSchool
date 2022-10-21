package com.microservice.forum.client;


import com.microservice.forum.bean.UserResponse;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@FeignClient(name = "USER-SERVICE" ,url="localhost:8060" , configuration = FeignClientConfiguration.class)
public interface UserClient {

@GetMapping(value="/api/username", consumes = "application/json")

@Headers("Authorization: application/json")
    public UserResponse getUser(@RequestHeader("Authorization") String bearerToken) ;

}

