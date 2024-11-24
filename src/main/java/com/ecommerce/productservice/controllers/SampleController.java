package com.ecommerce.productservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
* Request in Spring
* http://localhost:8080/sample/
* */

@RestController
@RequestMapping("/sample")
public class SampleController {

    //http:localhost:8080/sample/hello/
    @GetMapping("/hello")
    public String sayHello(){
        return "Hello World";
    }

    //http:localhost:8080/sample/goodBye/Noorul
    @GetMapping("/goodBye/{name}/{numberOfTimes}")
    public String sayGoodbye(@PathVariable("name") String name, @PathVariable("numberOfTimes") int numberOfTimes){
        String response = "";
        for(int i= 0; i< numberOfTimes;i++){
            String str = "Good Bye "+ name + "<br>";
            response += str;
        }
        return response;
    }
}
