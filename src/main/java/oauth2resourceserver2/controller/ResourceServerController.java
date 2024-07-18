package oauth2resourceserver2.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceServerController {

    @GetMapping("/hello")
    public String hello() {
        var a = SecurityContextHolder.getContext().getAuthentication();
        return "Hello World";
    }

}
