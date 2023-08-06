package com.enigmacamp.javak8s;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    @Value("${message.response}")
    String responseMessage;

    @GetMapping("/")
    ResponseEntity<CommonResponse> sayHelloWorld() {
        CommonResponse response = new CommonResponse();
        response.setMessage("Java - Hello World!");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/ping")
    ResponseEntity<CommonResponse> ping() {
        CommonResponse response = new CommonResponse();
        response.setMessage("Java - " + responseMessage);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
