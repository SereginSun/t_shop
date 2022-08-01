package com.seregin.tshop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Seregin Vladimir
 */
@Controller
public class HelloController {

//    @RequestMapping("/")
    @GetMapping("/hello-world")
    public String sayHello() {
        return "hello_world";
    }
}
