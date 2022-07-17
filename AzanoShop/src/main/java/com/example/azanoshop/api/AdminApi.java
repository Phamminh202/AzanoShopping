package com.example.azanoshop.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/admin")
public class AdminApi {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String helloAdmin() {
        return "you can see that message only if your account's role is admin";
    }
}
