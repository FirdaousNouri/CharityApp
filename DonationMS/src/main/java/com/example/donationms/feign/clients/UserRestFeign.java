package com.example.donationms.feign.clients;

import com.example.donationms.feign.mappers.Organisation;
import com.example.donationms.feign.mappers.User;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-ms")
public interface UserRestFeign {
    @GetMapping("/users/{id}")
    @CircuitBreaker(name = "userBreaker",fallbackMethod = "getDefaultUser")
    User AfficherUser(@PathVariable("id") Long userId);

    default User getDefaultUser(Long userId, Exception e){
        User user = new User();
        user.setName("Default User Name");
        return user;
    }
}
