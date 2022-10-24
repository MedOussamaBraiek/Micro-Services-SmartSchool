package com.microservice.forum.client;


import com.microservice.forum.beans.UserResponse;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;




@FeignClient(name = "USER-SERVICE", configuration = FeignClientInterceptor.class)
public interface UserClient {

    @GetMapping(value="/api/username", consumes = "application/json")
    @Headers("Authorization: application/json")
    public UserResponse getUser() ;

}
